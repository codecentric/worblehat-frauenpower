package de.codecentric.psd.worblehat.web.validator;

import org.apache.commons.validator.ISBNValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import de.codecentric.psd.worblehat.web.command.DeleteBookFormData;

/**
 * Validates DeleteBook.
 * 
 * @author asf19
 * 
 */
public class ValidateDeleteBook implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return DeleteBookFormData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (!supports(target.getClass())) {
			throw new IllegalArgumentException(
					"Not supported FormData for this validator: "
							+ target.getClass());
		}
		DeleteBookFormData cmd = (DeleteBookFormData) target;

		checkThatIsbnIsFilledAndValid(errors, cmd);

	}

	private void checkThatIsbnIsFilledAndValid(Errors errors,
			DeleteBookFormData cmd) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "isbn", "empty");
		if (!errors.hasFieldErrors("isbn")) {
			ISBNValidator isbnValidator = new ISBNValidator();
			if (!isbnValidator.isValid(cmd.getIsbn())) {
				errors.rejectValue("isbn", "notvalid");
			}
		}
	}

}
