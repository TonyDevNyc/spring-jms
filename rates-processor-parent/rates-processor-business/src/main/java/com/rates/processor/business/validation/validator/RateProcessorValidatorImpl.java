package com.rates.processor.business.validation.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rates.processor.business.validation.error.ValidationError;

public class RateProcessorValidatorImpl implements RatesProcessorValidator {

	private Validator jsr303Validator;

	@Override
	public Errors validate(final Object target, final String targetName) {
		ValidationError errors = new ValidationError(target, targetName);
		jsr303Validator.validate(target, errors);
		return errors;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// unused implementation
	}

	public void setJsr303Validator(Validator jsr303Validator) {
		this.jsr303Validator = jsr303Validator;
	}

}
