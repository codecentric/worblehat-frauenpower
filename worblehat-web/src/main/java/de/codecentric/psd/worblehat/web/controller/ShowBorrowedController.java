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
import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.command.ShowBorrowedFormData;
import de.codecentric.psd.worblehat.web.validator.ValidateReturnAllBooks;

/**
 * Controller class for the book table result.
 * 
 * @author psd
 * 
 */

/**
 * Controller for showing borrowed books from a user.
 * 
 * @author asf16
 * 
 */
@Controller
@RequestMapping("/showBorrowed")
public class ShowBorrowedController {

	@Inject
	private BookRepository bookRepository;

	@Inject
	private BookService bookService;

	ValidateReturnAllBooks validateReturnAllBooks = new ValidateReturnAllBooks();

	public ShowBorrowedController() {
		super();
	}

	/**
	 * 
	 * @param bookRepository
	 *            current book repository
	 */
	public ShowBorrowedController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * 
	 * @param modelMap
	 *            map of library
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		modelMap.put("showBorrowedFormData", new ShowBorrowedFormData());
	}

	/**
	 * 
	 * @param modelMap
	 *            map of library
	 * @param formdata
	 *            form data for brrowed books
	 * @param result
	 *            result handler
	 * @return command to execute
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String showBorrowedBooks(
			ModelMap modelMap,
			@ModelAttribute("showBorrowedFormData") ShowBorrowedFormData formdata,
			BindingResult result) {

		if (result.hasErrors()) {
			return "/showBorrowed";
		} else {
			List<Book> books = bookService.showAllBorrowedBooks(formdata
					.getEmailAddress());
			modelMap.addAttribute("books", books);
			return "/showBorrowed";
		}

		// bookService.returnAllBooksByBorrower(formData.getEmailAddress());

	}
}
