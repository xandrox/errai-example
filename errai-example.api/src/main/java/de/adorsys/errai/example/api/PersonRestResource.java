package de.adorsys.errai.example.api;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/persons")
public interface PersonRestResource {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Person create(Person person);
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> list();
	

}
