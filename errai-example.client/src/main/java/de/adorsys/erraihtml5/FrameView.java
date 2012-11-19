package de.adorsys.erraihtml5;

import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.SimplePanel;

@Templated
public class FrameView extends Composite {
	
//	@Inject
//	@DataField
//	OfferView offer;
//	
//	@Inject
//	@DataField
//	CalculatorView calculator;
	
	@DataField
	SimplePanel body = new SimplePanel();
	
	@Inject
	SavePersonView savePerson;
	
	@PostConstruct
	private void displayBody() {
		body.setWidget(savePerson);
	}
	
	void onPersonSaved(@Observes PersonSaved ps) {
		
	}

}
