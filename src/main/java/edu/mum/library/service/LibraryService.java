package edu.mum.library.service;

import edu.mum.library.model.Book;
import edu.mum.library.model.Member;

public interface LibraryService {

	void checkoutBook(String memberId, String isbn);

	void addMember(Member member);

	void addBookCopy(Book book);

	void addBook(Book book);

	void printCheckoutRecord(String memberId);
}
