package de.adorsys.erraihtml5;

import javax.validation.constraints.Min;

import org.jboss.errai.databinding.client.api.Bindable;

@Bindable
public class Calculator {
	@Min(5000)
	private Integer amount;

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
}
