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

/**
 * Controller class for the book table result.
 * 
 * @author psd
 * 
 */

@Controller
@RequestMapping("/deleteBook")
public class DeleteBookController {

	@Inject
	private BookRepository bookRepository;

	public DeleteBookController() {
		super();
	}

	public DeleteBookController(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@RequestMapping(method = RequestMethod.GET)
	public void setupForm(ModelMap modelMap) {
		modelMap.put("deleteBookFormData", new DeleteBookFormData());
	}

	@RequestMapping(method = RequestMethod.POST)
	public String deleteBook(ModelMap modelMap,
			@ModelAttribute("deleteBookFormData") DeleteBookFormData formdata,
			BindingResult result) {

		if (result.hasErrors()) {
			return "/deleteBook";
		} else {
			List<Book> booklist = bookRepository.findBooksByISBN(formdata
					.getIsbn());
			bookRepository.deleteBook(booklist.get(0));
			return "/home";
		}

		// bookService.returnAllBooksByBorrower(formData.getEmailAddress());

	}
}
