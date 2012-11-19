package de.adorsys.errai.example.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.jboss.errai.databinding.client.api.Bindable;

@Bindable
public class Person {

	@NotNull
	@NotBlank
	@Size(min=3)
	private String firstName;
	private String sureName;
	private Address address;

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
