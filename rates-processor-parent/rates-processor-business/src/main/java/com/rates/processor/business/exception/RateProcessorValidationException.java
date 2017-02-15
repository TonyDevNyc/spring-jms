package com.rates.processor.business.exception;

import org.springframework.validation.Errors;

public class RateProcessorValidationException extends RuntimeException {

	private static final long serialVersionUID = 1760739060510723417L;

	private Errors validationErrors;
	
	public RateProcessorValidationException() {
		super();
	}
	
	public RateProcessorValidationException(String msg) {
		super(msg);
	}
	
	public RateProcessorValidationException(String msg, Errors validationErrors) {
		super(msg);
		this.validationErrors = validationErrors;
	}

	public Errors getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Errors validationErrors) {
		this.validationErrors = validationErrors;
	}
}
