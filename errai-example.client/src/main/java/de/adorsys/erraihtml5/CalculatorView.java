package de.adorsys.erraihtml5;

import javax.annotation.PostConstruct;

import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.databinding.client.api.InitialState;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.SinkNative;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.inject.Inject;

@Templated("BodyView.html#calculator")
public class CalculatorView extends Composite {

	@Inject
	@DataField
	@Bound
	TextBox amount;

	@DataField
	SpanElement amountText = SpanElement.as(DOM.createSpan());

	@Inject
	@AutoBound
	DataBinder<Calculator> dataBinder;
	
	@Inject
	Validations validations;

	@PostConstruct
	public void init() {
		amountText.setInnerText("foo");
		Calculator model = new Calculator();
		model.setAmount(50);
		dataBinder.setModel(model, InitialState.FROM_MODEL);
	}

	@EventHandler("next")
	@SinkNative(Event.ONCLICK)
	public void doNext(Event e) {
		Calculator model = dataBinder.getModel();
		System.out.println(model.getAmount());
		validations.validate(model);
	}

}
