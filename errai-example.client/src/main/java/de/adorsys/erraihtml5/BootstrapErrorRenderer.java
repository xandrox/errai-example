package de.adorsys.erraihtml5;

import javax.validation.ConstraintViolation;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;

public class BootstrapErrorRenderer implements ErrorRenderer {

	@Override
	public void showErrror(ConstraintViolation<?> constraintViolation,
			Widget widget) {
		System.out.println("showerror:" + widget);
		Element controlGroup = findControlGroup(widget.getElement());
		controlGroup.addClassName("error");
	}

	@Override
	public void removeError(Widget widget) {
		System.out.println("remove:" + widget);
		Element controlGroup = findControlGroup(widget.getElement());
		controlGroup.removeClassName("error");
	}
	
	private Element findControlGroup(Element element) {
		if (element.getAttribute("class").contains("control-group")){
			return element;
		} else {
			return findControlGroup(element.getParentElement());
		}
	}

}
