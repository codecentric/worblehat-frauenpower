package de.codecentric.psd.worblehat.web.command;

public class DeleteBookFormData {

	private String isbn;

	public DeleteBookFormData() {
		super();
	}

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

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

}
