package de.adorsys.errai.example.api;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Version;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.jboss.errai.databinding.client.api.Bindable;

@Bindable
@NamedQueries( value={
		@NamedQuery(name="rudePersonSelect",query="SELECT o FROM Person o WHERE o.id = :id"),
		@NamedQuery(name="flexiblePersonSelect",query="SELECT o FROM Person o WHERE o.firstName LIKE :nameLike OR o.sureName LIKE :nameLike"),
})
@Entity
public class Person {

	@Id
	private @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	Long id = null;
	
	@Version
	private @Column(name = "version")
	int version = 0;

	@NotNull
	@NotBlank
	@Size(min = 3)
	private String firstName;

	@NotNull
	@NotBlank
	@Size(min = 3)
	private String sureName;

	@Valid
	@ManyToOne(cascade={CascadeType.ALL})
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
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the version
	 */
	public int getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	public void setVersion(int version) {
		this.version = version;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [id=" + id + ", version=" + version + ", firstName="
				+ firstName + ", sureName=" + sureName + ", address=" + address
				+ "]";
	}

}
