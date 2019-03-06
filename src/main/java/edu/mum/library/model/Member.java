package edu.mum.library.model;

import edu.mum.library.model.base.IPrimaryKeyGetter;
import edu.mum.library.model.base.PrimaryKeyHelper;

public class Member extends Person implements IPrimaryKeyGetter<String> {

	/**
	 *
	 */
	private static final long serialVersionUID = -9033791289938541323L;
	private CheckoutRecord checkoutRecord;

	private String memberId;

	public Member(String memberId, String firstName, String lastName, String phoneNumber) {
		super(firstName, lastName, phoneNumber);
		// TODO Auto-generated constructor stub
	}

	public void checkoutBook(BookCopy bc) {
		checkoutRecord.checkoutBook(this, bc);
	}

	@Override
	public boolean equals(Object obj) {
		return PrimaryKeyHelper.equals(this, obj);
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public String getMemberId() {
		return memberId;
	}

	@Override
	public int hashCode() {
		return PrimaryKeyHelper.hashCode(this);
	}

	public void printCheckoutRecord() {
		checkoutRecord.printCheckoutRecord();
	}

	@Override
	public String getPrimaryKey() {
		// TODO Auto-generated method stub
		return this.getMemberId();
	}
}
