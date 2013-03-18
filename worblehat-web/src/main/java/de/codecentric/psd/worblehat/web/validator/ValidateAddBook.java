package de.codecentric.psd.worblehat.web.validator;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.validator.ISBNValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.codecentric.psd.worblehat.web.command.BookDataFormData;

/**
 * Validation for adding a book
 * 
 * @author mahmut.can
 * 
 */
public class ValidateAddBook implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BookDataFormData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		if (!supports(target.getClass()))
			throw new IllegalArgumentException("Validation of classs '"
					+ target.getClass() + "' is not supported");

		BookDataFormData cmd = (BookDataFormData) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title",
				"empty, please enter a valid title");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author",
				"empty, please enter a valid author");

		checkThatYearIsFilledAndValid(errors, cmd);
		checkThatIsbnIsFilledAndValid(errors, cmd);
		checkThatEditionisFilledAndValid(errors, cmd);

	}

	private void checkThatEditionisFilledAndValid(Errors errors,
			BookDataFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "edition",
				"empty, please enter a valid edition");
		if (!errors.hasFieldErrors("edition")) {
			if (!StringUtils.isNumeric(cmd.getEdition())) {
				errors.rejectValue("edition", "notvalid");
			}
		}
	}

	private void checkThatIsbnIsFilledAndValid(Errors errors,
			BookDataFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn",
				"empty, please enter a valid isbn");
		if (!errors.hasFieldErrors("isbn")) {
			ISBNValidator isbnValidator = new ISBNValidator();
			if (!isbnValidator.isValid(cmd.getIsbn())) {
				errors.rejectValue("isbn", "notvalid");
			}
		}
	}

	private void checkThatYearIsFilledAndValid(Errors errors,
			BookDataFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "year",
				"empty, please enter a valid year");
		if (!errors.hasFieldErrors("year")) {
			if (!StringUtils.isNumeric(cmd.getYear())) {
				errors.rejectValue("year", "Only numbers allowed, eg 1999");
			} else if (StringUtils.length(cmd.getYear()) != 4) {
				errors.rejectValue("year", "Must have 4 numbers, eg 1999");
			}
		}
	}

}
