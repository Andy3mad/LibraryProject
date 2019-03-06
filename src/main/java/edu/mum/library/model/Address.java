package edu.mum.library.model;

import edu.mum.library.model.base.BaseEntity;

public class Address extends BaseEntity {

	/**
	 *
	 */
	private static final long serialVersionUID = -7402787440134026375L;
	private final String street;
	private final String city;
	private final String state;
	private final String zipcode;

	public Address(String street, String city, String state, String zipcode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZipcode() {
		return zipcode;
	}

}
