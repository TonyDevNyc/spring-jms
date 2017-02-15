package com.rates.processor.business.validation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public interface RatesProcessorValidator extends Validator {

	Errors validate(Object target, String targetName);
	
}
