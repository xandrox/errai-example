package de.adorsys.erraihtml5.person;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;

import de.adorsys.errai.example.api.Person;
import de.adorsys.erraihtml5.support.Val;

@Templated
public class SavePersonView extends Composite {
	
	@Inject
	@DataField
	@Bound
	TextBox firstName;
	
	@Inject
	@DataField
	@Bound
	TextBox sureName;
	
	@Inject
	Val validations;
	
	@Inject
	@AutoBound
	DataBinder<Person> dataBinder;
	
	@Inject
	javax.enterprise.event.Event<PersonSaved> personSaved;

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
		System.out.println(model);
		
		personSaved.fire(new PersonSaved());
//		validations.validate(model);
	}
}
