package de.adorsys.erraihtml5;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.bus.client.api.ErrorCallback;
import org.jboss.errai.bus.client.api.Message;
import org.jboss.errai.bus.client.api.RemoteCallback;
import org.jboss.errai.bus.client.api.base.TransportIOException;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.enterprise.client.jaxrs.api.RestClient;
import org.jboss.errai.ioc.client.api.Caller;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;

import de.adorsys.errai.example.api.Address;
import de.adorsys.errai.example.api.Person;
import de.adorsys.errai.example.api.PersonRestResource;

@Templated
public class SavePersonView extends Composite {
	
	
	@Inject
	@DataField
	@org.jboss.errai.ui.shared.api.annotations.Bound
	TextBox firstName;
	
	
	@Inject
	Validations validations;
	
	@Inject
	@AutoBound
	DataBinder<Person> dataBinder;
	@Inject
	javax.enterprise.event.Event<PersonOperation> personSaved;
	
	@Inject
	Caller<PersonRestResource> personRestCaller ;
	@PostConstruct
	private void init() {
		//dataBinder.setModel(new Person());
	}
	
	@EventHandler("save")
	@SinkNative(Event.ONCLICK)
	public void doNext(Event e) {
		validations.validate(dataBinder.getModel());
		
		System.out.println(firstName.getValue());
		Person model = dataBinder.getModel();
		model.setAddress(new Address());
		System.out.println(model);
		RestClient.setApplicationRoot("http://localhost:8080/errai-example.server/rest");
		RestClient.setJacksonMarshallingActive(true);
		RemoteCallback<Person> remoteCallback = new RemoteCallback<Person>() {

			@Override
			public void callback(Person person) {
				System.out.println("Response "+person);
			}
		};
		ResponseCallback responseCallback = new ResponseCallback() {
			
			@Override
			public void callback(Response response) {
				System.out.println("Response "+response.getText());
			}
		};

		ErrorCallback errorCallback = new ErrorCallback() {
			@Override
			public boolean error(Message message, Throwable throwable) {
				if(throwable instanceof TransportIOException){
					System.out.println("Could Reach the server : ["+message+"]  \n and ["+throwable+"]" );
				}else {
					System.out.println("Marschalling errors ["+message+"]  \n and ["+throwable+"]" );
				}
				return true;
			}
		};
		personRestCaller.call(responseCallback, errorCallback).create(model);
		personRestCaller.call(responseCallback,errorCallback).list();
		PersonOperation personOperation = new PersonOperation(model, PersonOperationType.CREATE_SUCCESS);
		
		personSaved.fire(personOperation);
//		validations.validate(model);
	}
	
}
