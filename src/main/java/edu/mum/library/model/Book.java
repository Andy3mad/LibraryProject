package edu.mum.library.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import edu.mum.library.model.base.BaseEntityWithPrimaryKey;

public class Book extends BaseEntityWithPrimaryKey<String> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1132196726352622831L;
	private int availability;

	private List<Author> bookAuthors;

	private List<BookCopy> bookCopies;

	private String isbn;

	private String title;

	public Book(String title, String isbn, int availability, List<Author> authorList) {
		super();
		this.title = title;
		this.isbn = isbn;
		this.availability = availability;

		bookCopies = new ArrayList<>();
		bookAuthors = new ArrayList<>();
	}

	// public void addBookCopy() {
	// String generated_id = this.getIsbn() + "_copy_" + (bookCopies.size() +
	// 1);
	// bookCopies.add(new BookCopy(generated_id, true));
	// }
	public void addBookCopy() {
		int index = LocalDate.now().getYear() * 10000 + LocalDate.now().getMonthValue() * 100 + (bookCopies.size() + 1);
		addBookCopy(index);
	}

	private void addBookCopy(int index) {
		String generated_id = this.getIsbn() + "_copy_" + index;
		bookCopies.add(new BookCopy(generated_id, true));
	}

	public int getAvailability() {
		return availability;
	}

	public List<Author> getBookAuthors() {
		return Collections.unmodifiableList(bookAuthors);
	}

	public List<BookCopy> getBookCopies() {
		return Collections.unmodifiableList(bookCopies);
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String getPrimaryKey() {
		return getIsbn();
	}

	public BookCopy allocateCopy() {

		Optional<BookCopy> bcOptional = bookCopies.stream().filter(bc -> bc.isAvailable()).findAny();
		return bcOptional.isPresent() ? bcOptional.get() : null;
	}

}
