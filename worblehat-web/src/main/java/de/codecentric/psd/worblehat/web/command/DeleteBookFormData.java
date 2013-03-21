package de.codecentric.psd.worblehat.web.command;

/**
 * Form for deleting a book by isbn.
 * 
 * @author asf16
 * 
 */
public class DeleteBookFormData {

	private String isbn;

	/**
	 * 
	 */
	public DeleteBookFormData() {
		super();
	}

	/**
	 * 
	 * @param isbn
	 *            isbn of book to delete
	 */
	public DeleteBookFormData(String isbn) {
		boolean exists = isbn != null;

		if (exists) {
			this.isbn = isbn.replaceAll(" ", "");
		} else {
			this.isbn = isbn;
		}

	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * 
	 * @param isbn
	 *            isbn of book to delete
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
