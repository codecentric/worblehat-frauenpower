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

	public void setYear(String year) {
		if (year != null)
			this.year = year.replaceAll(" ", "");
		else
			this.year = year;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		if (isbn != null)
			this.isbn = isbn.replaceAll(" ", "");
		else
			this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAbstract() {
		return abstr;
	}

	public void setAbstract(String abstr) {
		this.abstr = abstr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEdition() {
		return edition;
	}

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
