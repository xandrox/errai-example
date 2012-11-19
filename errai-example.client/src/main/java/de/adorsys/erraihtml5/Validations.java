package de.adorsys.erraihtml5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Singleton;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Path.Node;
import javax.validation.Validator;

import org.jboss.errai.databinding.client.BindableProxy;
import org.jboss.errai.databinding.client.BindableProxyFactory;
import org.jboss.errai.databinding.client.api.InitialState;

import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

@Singleton
public class Validations {
	
	@Inject
	Validator validator;
	
	public void validate(Object object, Class<?>... groups) {
		BindableProxy<?> proxy = (BindableProxy<?>) object;
		Set<ConstraintViolation<Object>> validate = validator.validate(proxy.unwrap(), groups);
		mapViolations(validate, proxy);
	}

	public void mapViolations(Collection<ConstraintViolation<Object>> cv, BindableProxy<?> proxy) {
		for (ConstraintViolation<?> constraintViolation : cv) {
			System.out.println(constraintViolation.getPropertyPath());
			Widget widget = proxy.getState().getWidget(constraintViolation.getPropertyPath().toString());
			System.out.println(widget);
		}
	}

	private static String getProperty(Iterator<Node> iterator) {
		String lastProp = null;
		while (iterator.hasNext()) {
			Path.Node node = (Path.Node) iterator.next();
			lastProp = node.getName();
		}
		return lastProp;
	}
	
}
