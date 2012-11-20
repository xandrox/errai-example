package de.adorsys.errai.example.api;

import javax.validation.constraints.NotNull;

import org.jboss.errai.databinding.client.api.Bindable;

@Bindable
public class Person {

	@NotNull
	private String firstName;
	private String sureName;
	private Address address;

	
	public Person() {
		super();
	}

	public Person(String firstName, String sureName, Address address) {
		super();
		this.firstName = firstName;
		this.sureName = sureName;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSureName() {
		return sureName;
	}

	public void setSureName(String sureName) {
		this.sureName = sureName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", sureName=" + sureName
				+ ", address=" + address + "]";
	}
	
}
