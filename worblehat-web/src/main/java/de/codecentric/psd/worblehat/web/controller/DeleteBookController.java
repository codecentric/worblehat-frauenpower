package de.codecentric.psd.worblehat.web.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
