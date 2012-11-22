package de.adorsys.errai.example.server;

import de.adorsys.errai.example.api.Address;
import de.adorsys.errai.example.api.Person;
import de.adorsys.errai.example.server.domain.PersonData;

public class Utils {
	
	public static PersonData giveMeAPersonData(Person person){
		if(person == null ) throw new IllegalArgumentException("How could a person be null ?");
		PersonData personData = new PersonData();
		personData.setFirstName(person.getFirstName());
		personData.setSureName(person.getSureName());
		return personData;
	}
	
	public static Person giveMeAPerson(PersonData personData){
		if(personData == null)throw new IllegalArgumentException("Invalid data [null], for creating a person");
		Person person = new Person();
		person.setAddress(new Address());
		person.setFirstName(personData.getFirstName());
		person.setSureName(personData.getSureName());
		return person;
	}
}
