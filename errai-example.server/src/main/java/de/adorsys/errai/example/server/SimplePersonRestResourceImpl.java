package de.adorsys.errai.example.server;

import java.util.ArrayList;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.adorsys.errai.example.api.Address;
import de.adorsys.errai.example.api.Person;
import de.adorsys.errai.example.api.PersonRestResource;
import de.adorsys.errai.example.server.domain.PersonData;
@ApplicationScoped
@Stateless
public class SimplePersonRestResourceImpl implements PersonRestResource{
	@PersistenceContext
	private EntityManager em ;
	
	private static Logger LOG = Logger.getLogger("SimplePersonRestResourceImpl.java");
	
	public Person create(Person person){
		LOG.info("New Person  "+person);
		PersonData personData = Utils.giveMeAPersonData(person);
		try {
			em.persist(personData);
		} catch (Exception e) {
			e.printStackTrace();
		}
		person.setFirstName(personData.getFirstName()+"-"+personData.getId());
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
