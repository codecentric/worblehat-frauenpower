package de.codecentric.psd.worblehat.web.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookRepository;
import de.codecentric.psd.worblehat.web.command.DeleteBookFormData;
import de.codecentric.psd.worblehat.web.validator.ValidateDeleteBook;

/**
 * Controller class for the book table result.
 * 
 * @author psd
 * 
 */

/**
 * Controller for deleting books by isbn.
 * 
 * @author asf16
 * 
 */
@Controller
@RequestMapping("/deleteBook")
public class DeleteBookController {

	@Inject
	private BookRepository bookRepository;

	private final ValidateDeleteBook validateDeleteBook = new ValidateDeleteBook();

	public DeleteBookController() {
		super();
	}

	/**
	 * 
	 * @param bookRepository
	 *            current book repo
	 */
	public DeleteBookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * 
	 * @param modelMap
	 *            current map of library
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		modelMap.put("deleteBookFormData", new DeleteBookFormData());
	}

	/**
	 * 
	 * @param modelMap
	 *            map of library
	 * @param formdata
	 *            form data for deleting books
	 * @param result
	 *            result handler
	 * @return command to execute
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String deleteBook(ModelMap modelMap,
			@ModelAttribute("deleteBookFormData") DeleteBookFormData formdata,
			BindingResult result) {
		validateDeleteBook.validate(formdata, result);

		if (result.hasErrors()) {

			return "/deleteBook";
		} else {
			try {
				List<Book> booklist = bookRepository.findBooksByISBN(formdata
						.getIsbn());
				if (booklist.size() == 0) {
					result.rejectValue("isbn", "present");
					return "/deleteBook";
				} else {
					if (!booklist.get(0).getCurrentBorrowing()
							.getBorrowerEmailAddress().isEmpty()) {
						result.rejectValue("isbn", "borrowed");
						return "/deleteBook";
					}
				}
				bookRepository.deleteBook(booklist.get(0));

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "/home";
		}

		// bookService.returnAllBooksByBorrower(formData.getEmailAddress());

	}
}
