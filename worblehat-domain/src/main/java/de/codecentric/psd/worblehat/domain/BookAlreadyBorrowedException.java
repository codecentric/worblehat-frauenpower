package de.codecentric.psd.worblehat.domain;

/**
 * Exception for borrowing a book.
 * 
 * @author mahmut.can
 * 
 */
public class BookAlreadyBorrowedException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 *            error message
	 */
	public BookAlreadyBorrowedException(String message) {
		super(message);
	}

}
