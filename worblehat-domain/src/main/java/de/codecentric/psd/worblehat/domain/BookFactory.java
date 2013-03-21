package de.codecentric.psd.worblehat.domain;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

/**
 * 
 * A Factory for Book Enitty
 * 
 * @author mahmut.can
 * 
 */
@Service
public class BookFactory {

	private final BookRepository bookRepository;

	/**
	 * 
	 * @param bookRepository
	 *            current book repository
	 */
	@Inject
	BookFactory(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	};

	/**
	 * 
	 * @param title
	 *            title for new book
	 * @param author
	 *            author for new book
	 * @param edition
	 *            edition for new book
	 * @param isbn
	 *            isbn for new book
	 * @param year
	 *            year for new book
	 * @param abstr
	 *            description for new book
	 * @return new book entity
	 */
	public Book createBook(String title, String author, String edition,
			String isbn, int year, String abstr) {
		Book book = new Book(title, author, edition, isbn, year, abstr);
		bookRepository.store(book);
		return book;
	}

}
