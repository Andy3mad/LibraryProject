package edu.mum.library.model;

import java.time.LocalDate;

import edu.mum.library.model.base.BaseEntity;

public class CheckoutEntry extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = -5736932388801761095L;

	private LocalDate checkoutDate;
	private LocalDate dueDate;

	private Member member;
	private BookCopy bookCopy;

	//package
	CheckoutEntry(LocalDate checkoutDate, LocalDate dueDate, Member member, BookCopy bookCopy) {
		super();
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		this.member = member;
		this.bookCopy = bookCopy;
	}

	public BookCopy getBookCopy() {
		return bookCopy;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public Member getMember() {
		return member;
	}

}
