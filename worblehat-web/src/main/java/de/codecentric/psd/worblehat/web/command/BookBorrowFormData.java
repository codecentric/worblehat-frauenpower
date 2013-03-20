package de.codecentric.psd.worblehat.web.command;

/**
 * Form data object from the borrow view.
 * 
 * @author psd
 * 
 */
public class BookBorrowFormData {

	private String isbn; // isbn 10stellig
	private String email;

	/**
	 * Empty constructor, required by Spring Framework.
	 */
	public BookBorrowFormData() {
		super();
	}

	/**
	 * Constructor for testing.
	 * 
	 * @param isbn
	 *            the isbn
	 * @param email
	 *            the user email address
	 */
	public BookBorrowFormData(String isbn, String email) {

		boolean exists = isbn != null;

		if (exists) {
			this.isbn = isbn.replaceAll(" ", "");
		} else {
			this.isbn = isbn;
		}

		if (email != null) {
			this.email = email.replaceAll(" ", "");
		} else {
			this.email = email;
		}
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn != null) {
			this.isbn = isbn.replaceAll(" ", "");
		} else {
			this.isbn = isbn;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email != null) {
			this.email = email.replaceAll(" ", "");
		} else {
			this.email = email;
		}
	}

}
