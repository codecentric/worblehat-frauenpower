package de.codecentric.psd.worblehat.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.command.ReturnAllBooksFormData;
import de.codecentric.psd.worblehat.web.validator.ValidateReturnAllBooks;

/**
 * Controller class for the return of book.
 * 
 * @author psd
 * 
 */
@Controller
@RequestMapping("/returnAllBooks")
public class ReturnAllBookController {

	ValidateReturnAllBooks validateReturnAllBooks = new ValidateReturnAllBooks();

	@Inject
	private BookService bookService;

	/**
	 * 
	 * @param modelMap
	 *            map for library
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void prepareView(ModelMap modelMap) {
		modelMap.put("returnAllBookFormData", new ReturnAllBooksFormData());
	}

	/**
	 * 
	 * @param modelMap
	 *            map for library
	 * @param formData
	 *            for data for return of book
	 * @param result
	 *            result handler
	 * @return command to execute
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String returnAllBooks(
			ModelMap modelMap,
			@ModelAttribute("returnAllBookFormData") ReturnAllBooksFormData formData,
			BindingResult result) {
		validateReturnAllBooks.validate(formData, result);
		if (result.hasErrors()) {
			return "/returnAllBooks";
		} else {
			bookService.returnAllBooksByBorrower(formData.getEmailAddress());
			return "/home";
		}
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}
}
