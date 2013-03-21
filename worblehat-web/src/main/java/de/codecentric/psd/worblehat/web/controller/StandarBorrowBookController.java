package de.codecentric.psd.worblehat.web.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.codecentric.psd.worblehat.domain.Book;
import de.codecentric.psd.worblehat.domain.BookAlreadyBorrowedException;
import de.codecentric.psd.worblehat.domain.BookRepository;
import de.codecentric.psd.worblehat.domain.NoBookBorrowableException;
import de.codecentric.psd.worblehat.web.command.BookBorrowFormData;
import de.codecentric.psd.worblehat.web.validator.ValidateBorrowBook;

/**
 * Controller for BorrowingBook
 * 
 * @author mahmut.can
 * 
 */
@Transactional
@RequestMapping("/borrow")
@Controller
public class StandarBorrowBookController {

	private BookRepository bookRepository;
	private ValidateBorrowBook validator = new ValidateBorrowBook();

	/**
	 * 
	 * @param bookRepository
	 *            contains all books currently inthe library
	 */
	@Inject
	public StandarBorrowBookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * 
	 */
	public StandarBorrowBookController() {
	}

	/**
	 * 
	 * @param model
	 *            model of library
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(final ModelMap model) {
		model.put("borrowFormData", new BookBorrowFormData());
	}

	/**
	 * 
	 * @param modelMap
	 *            current model map
	 * @param cmd
	 *            form containing user input
	 * @param result
	 *            result handler
	 * 
	 * @return command to execute
	 */
	@Transactional
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(ModelMap modelMap,
			@ModelAttribute("borrowFormData") BookBorrowFormData cmd,
			BindingResult result) {

		validator.validate(cmd, result);
		if (result.hasErrors()) {
			modelMap.put("borrowFormData", cmd);
			return "/borrow";
		}
		Book book;
		try {
			book = bookRepository.findBorrowableBook(cmd.getIsbn());
			book.borrow(cmd.getEmail());

		} catch (NoBookBorrowableException e) {
			result.rejectValue("isbn", "notBorrowable");
			modelMap.put("borrowFormData", cmd);
			return "/borrow";

		} catch (BookAlreadyBorrowedException e) {
			result.reject("internalError");
			modelMap.put("borrowFormData", cmd);
			return "/borrow";
		}

		return "/home";
	}

	/**
	 * 
	 * @param validater
	 *            validator for borrow book form data
	 */
	public void setValidator(ValidateBorrowBook validater) {
		this.validator = validater;
	}

	/**
	 * 
	 * @param ex
	 *            exception handler
	 * @param request
	 *            http request for command execution
	 * @return command to execute
	 */
	@ExceptionHandler(Exception.class)
	public String handleErrors(Exception ex, HttpServletRequest request) {
		return "/home";
	}
}
