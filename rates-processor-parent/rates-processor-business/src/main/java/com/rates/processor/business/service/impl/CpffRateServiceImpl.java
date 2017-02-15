package com.rates.processor.business.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.rates.processor.business.DateUtils;
import com.rates.processor.business.dto.cpff.CpffRateCreateRequest;
import com.rates.processor.business.dto.cpff.CpffRateCreateResponse;
import com.rates.processor.business.dto.cpff.CpffRateGetByIdRequest;
import com.rates.processor.business.dto.cpff.CpffRateGetByTxnDateRequest;
import com.rates.processor.business.dto.cpff.CpffRateResponse;
import com.rates.processor.business.exception.RateProcessorValidationException;
import com.rates.processor.business.service.CpffRateService;
import com.rates.processor.business.validation.validator.RatesProcessorValidator;
import com.rates.processor.persistence.domain.CpffRateDomain;
import com.rates.processor.persistence.jdbc.dao.CpffRateDao;

@Transactional(transactionManager = "transactionManager")
public class CpffRateServiceImpl implements CpffRateService {

	private static final Logger LOGGER = Logger.getLogger(CpffRateServiceImpl.class);

	private CpffRateDao cpffRateDao;

	private RatesProcessorValidator validator;

	@Override
	public CpffRateCreateResponse createCpffRate(CpffRateCreateRequest request) {
		String method = "createCpffRate";
		LOGGER.info("Inside service api - [method=" + method + "]");
		Errors validationErrors = validator.validate(request, method);
		if (validationErrors.hasErrors()) {
			String msg = "A validation error has occurred - method=[" + method + "]";
			LOGGER.error(msg);
			throw new RateProcessorValidationException(msg, validationErrors);
		}

		CpffRateDomain domain = buildCpffRateDomain(request);
		Long id = cpffRateDao.insertCpffRateDomain(domain);

		CpffRateCreateResponse response = new CpffRateCreateResponse();
		response.setId(id);

		LOGGER.info("Returned from service api - [method=" + method + "], [id=" + id + "]");
		return response;
	}

	@Override
	public CpffRateResponse getCpffRateById(CpffRateGetByIdRequest request) {
		String method = "getCpffRateById";
		LOGGER.info("Inside service api - [method=" + method + "]");
		Errors validationErrors = validator.validate(request, method);
		
		if (validationErrors.hasErrors()) {
			String msg = "A validation error has occurred - method=[" + method + "]";
			LOGGER.error(msg);
			throw new RateProcessorValidationException(msg, validationErrors);
		}
		
		CpffRateDomain domain = cpffRateDao.selectCpffRateById(request.getId());
		CpffRateResponse response = buildCpffRateResponse(domain);
		LOGGER.info("Returned from service api - [method=" + method + "], [id=" + request.getId() + "]");
		return response;
	}

	@Override
	public CpffRateResponse getCpffRateByTxnDate(CpffRateGetByTxnDateRequest request) {
		String method = "getCpffRateByTxnDate";
		LOGGER.info("Inside service api - [method=" + method + "]");
		Errors validationErrors = validator.validate(request, method);
		
		if (validationErrors.hasErrors()) {
			String msg = "A validation error has occurred - method=[" + method + "]";
			LOGGER.error(msg);
			throw new RateProcessorValidationException(msg, validationErrors);
		}
		
		CpffRateDomain domain = cpffRateDao.selectCpffRateByTransactionDate(DateUtils.convertToSqlDate(request.getTransactionDate()));
		CpffRateResponse response = buildCpffRateResponse(domain);
		LOGGER.info("Returned from service api - [method=" + method + "], [transactionDate=" + request.getTransactionDate() + "]");
		return response;
	}

	public void setCpffRateDao(CpffRateDao cpffRateDao) {
		this.cpffRateDao = cpffRateDao;
	}

	public void setValidator(RatesProcessorValidator validator) {
		this.validator = validator;
	}

	private CpffRateDomain buildCpffRateDomain(CpffRateCreateRequest dto) {
		CpffRateDomain domain = new CpffRateDomain();
		domain.setTransactionDate(dto.getTransactionDate());
		domain.setUnsecuredRate(dto.getUnsecuredRate());
		domain.setSecuredRate(dto.getSecuredRate());
		domain.setMaturityDate(dto.getMaturityDate());
		return domain;
	}

	private CpffRateResponse buildCpffRateResponse(CpffRateDomain domain) {
		CpffRateResponse response = new CpffRateResponse();
		if (domain != null) {
			BeanUtils.copyProperties(domain, response);
		}
		return response;
	}
}
