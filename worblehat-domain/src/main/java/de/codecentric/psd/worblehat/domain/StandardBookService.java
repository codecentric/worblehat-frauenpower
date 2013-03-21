package de.codecentric.psd.worblehat.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The domain service class for book operations.
 * 
 * @author psd
 * 
 */
@Service
@Transactional
public class StandardBookService implements BookService {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * 
	 * @param bookRepository
	 *            current book repo containing all library book
	 */
	public StandardBookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * Calls super constructor.
	 */
	public StandardBookService() {
		super();
	}

	@Override
	public void returnAllBooksByBorrower(String string) {
		List<Book> borrowBooks = bookRepository
				.findAllBorrowBooksByBorrower(string);
		for (Book book : borrowBooks) {
			book.returnBook();

		}

	}

	@Override
	public List<Book> showAllBorrowedBooks(String string) {
		List<Book> borrowBooks = bookRepository
				.findAllBorrowBooksByBorrower(string);
		borrowBooks.get(1).
		return borrowBooks;
	}
}
