package de.adorsys.erraihtml5;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;

import de.adorsys.errai.example.api.Person;

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
//		validations.validate(model);
	}
}
