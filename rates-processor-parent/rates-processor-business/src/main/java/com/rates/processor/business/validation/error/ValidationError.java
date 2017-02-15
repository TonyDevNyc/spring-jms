package com.rates.processor.business.validation.error;

import org.springframework.validation.BeanPropertyBindingResult;

public class ValidationError extends BeanPropertyBindingResult {

	private static final long serialVersionUID = 5812013277941115133L;

	public ValidationError(Object target, String objectName) {
		super(target, objectName);
	}
}
