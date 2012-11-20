package de.adorsys.errai.example.server;

import java.util.ArrayList;

import java.util.List;

import de.adorsys.errai.example.api.Address;
import de.adorsys.errai.example.api.Person;
import de.adorsys.errai.example.api.PersonRestResource;
public class SimplePersonRestResourceImpl implements PersonRestResource{
	
	public Person create(Person person){
		System.out.println("New Person  "+person);
		person.setFirstName(person.getFirstName()+"-II");
		return person ;
	}
	public List<Person> list(){
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person("Ada ","Lovelace", new Address("St James's Square", "N/A","London")));
		persons.add(new Person("James ","Puckle", new Address("N/A", "N/A","London")));
		System.out.println("Persons  : \n "+persons);
		return persons;
	}
	
}
