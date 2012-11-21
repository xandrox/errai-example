package de.adorsys.errai.example.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.jboss.errai.databinding.client.api.Bindable;

@Bindable
public class Address {

	@NotNull
	@NotBlank
	@Size(min=3)
	private String street;
	
	@NotNull
	@NotBlank
	@Size(min=3)
	private String postcode;
	
	@NotNull
	@NotBlank
	@Size(min=3)
	private String city;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", postcode=" + postcode
				+ ", city=" + city + "]";
	}

}
