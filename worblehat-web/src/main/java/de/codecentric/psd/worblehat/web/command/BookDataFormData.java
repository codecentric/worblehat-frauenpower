package de.codecentric.psd.worblehat.web.command;

/**
 * @author mahmut.can
 * 
 */
public class BookDataFormData {

	private String title;
	private String edition;
	private String year;
	private String isbn;
	private String author;
	private String abstr;

	public String getYear() {
		return year;
	}

	/**
	 * 
	 * @param year
	 *            year the book was published
	 */
	public void setYear(String year) {

		boolean exists = year != null;
		if (exists) {
			this.year = year.replaceAll(" ", "");
		} else {
			this.year = year;
		}
	}

	public String getIsbn() {
		return isbn;
	}

	/**
	 * 
	 * @param isbn
	 *            isbn of book
	 */
	public void setIsbn(String isbn) {

		boolean exists = isbn != null;
		if (exists) {
			this.isbn = isbn.replaceAll(" ", "");
		} else {
			this.isbn = isbn;
		}
	}

	public String getAuthor() {
		return author;
	}

	/**
	 * 
	 * @param author
	 *            author of book
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAbstract() {
		return abstr;
	}

	/**
	 * 
	 * @param abstr
	 *            description of book
	 */
	public void setAbstract(String abstr) {
		this.abstr = abstr;
	}

	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            title of book
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

	/**
	 * 
	 * @param edition
	 *            edition of book
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	@Override
	public String toString() {
		return "BookDataFormData [title=" + title + ", edition=" + edition
				+ ", year=" + year + ", isbn=" + isbn + ", author=" + author
				+ "]";
	}

}
