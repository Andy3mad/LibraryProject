package edu.mum.library.dataaccess.storage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.mum.library.model.Book;
import edu.mum.library.model.Member;

public class Database implements Serializable {

	private static final long serialVersionUID = -6824278077021225904L;
	List<Member> member;
	List<Book> book;

	public Database() {
		super();

		member = new ArrayList<>();
		book = new ArrayList<>();
	}

	public List<Member> getMember() {
		return member;
	}

	public List<Book> getBook() {
		return book;
	}

}
