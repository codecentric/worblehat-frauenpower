package de.codecentric.psd.worblehat.domain;

import java.util.List;

/**
 * The interface of the domain service for books.
 * 
 * @author psd
 * 
 */
public interface BookService {

	void returnAllBooksByBorrower(String string);

	List<Book> showAllBorrowedBooks(String string);

}
