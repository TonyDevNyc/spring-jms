package com.rates.processor.business.exception;

public class RateProcessorException extends RuntimeException {

	private static final long serialVersionUID = -1962104229465744327L;

	public RateProcessorException() {
		super();
	}

	public RateProcessorException(String msg) {
		super(msg);
	}
}
