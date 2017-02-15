package com.rates.processor.business.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.rates.processor.business.DateUtils;
import com.rates.processor.business.dto.marketrate.MarketRateCreateRequest;
import com.rates.processor.business.dto.marketrate.MarketRateCreateResponse;
import com.rates.processor.business.dto.marketrate.MarketRateGetByIdRequest;
import com.rates.processor.business.dto.marketrate.MarketRateGetByTxnDateRequest;
import com.rates.processor.business.dto.marketrate.MarketRateResponse;
import com.rates.processor.business.exception.RateProcessorValidationException;
import com.rates.processor.business.service.MarketRateService;
import com.rates.processor.business.validation.validator.RatesProcessorValidator;
import com.rates.processor.persistence.domain.MarketRatesDomain;
import com.rates.processor.persistence.jdbc.dao.MarketRateDao;

@Transactional(transactionManager = "transactionManager")
public class MarketRateServiceImpl implements MarketRateService {

	private static final Logger LOGGER = Logger.getLogger(MarketRateServiceImpl.class);

	private MarketRateDao marketRateDao;

	private RatesProcessorValidator validator;
	
	@Override
	public MarketRateCreateResponse createMarketRate(MarketRateCreateRequest request) {
		String method = "createMarketRate";
		LOGGER.info("Inside service api - [method=" + method + "]");
		Errors validationErrors = validator.validate(request, method);
		if (validationErrors.hasErrors()) {
			String msg = "A validation error has occurred - method=[" + method + "]";
			LOGGER.error(msg);
			throw new RateProcessorValidationException(msg, validationErrors);
		}

		MarketRatesDomain domain = buildMarketRateDomain(request);
		Long id = marketRateDao.insertMarketRate(domain);

		MarketRateCreateResponse response = new MarketRateCreateResponse();
		response.setId(id);

		LOGGER.info("Returned from service api - [method=" + method + "], [id=" + id + "]");
		return response;
	}

	@Override
	public MarketRateResponse getMarketRateById(MarketRateGetByIdRequest request) {
		String method = "getMarketRateById";
		LOGGER.info("Inside service api - [method=" + method + "]");
		Errors validationErrors = validator.validate(request, method);
		
		if (validationErrors.hasErrors()) {
			String msg = "A validation error has occurred - method=[" + method + "]";
			LOGGER.error(msg);
			throw new RateProcessorValidationException(msg, validationErrors);
		}
		
		MarketRatesDomain domain = marketRateDao.selectMarketRatesById(request.getId());
		MarketRateResponse response = buildMarketRateResponse(domain);
		LOGGER.info("Returned from service api - [method=" + method + "], [id=" + request.getId() + "]");
		return response;
	}

	@Override
	public MarketRateResponse getMarketRateByTxnDate(MarketRateGetByTxnDateRequest request) {
		String method = "getMarketRateByTxnDate";
		LOGGER.info("Inside service api - [method=" + method + "]");
		Errors validationErrors = validator.validate(request, method);
		
		if (validationErrors.hasErrors()) {
			String msg = "A validation error has occurred - method=[" + method + "]";
			LOGGER.error(msg);
			throw new RateProcessorValidationException(msg, validationErrors);
		}
		
		MarketRatesDomain domain = marketRateDao.selectMarketRatesByTransactionDate(DateUtils.convertToSqlDate(request.getTransactionDate()), request.getRateType());
		MarketRateResponse response = buildMarketRateResponse(domain);
		LOGGER.info("Returned from service api - [method=" + method + "], [transactionDate=" + request.getTransactionDate() + "], rateType=["+request.getRateType()+"]");
		return response;
	}

	public void setMarketRateDao(MarketRateDao marketRateDao) {
		this.marketRateDao = marketRateDao;
	}

	public void setValidator(RatesProcessorValidator validator) {
		this.validator = validator;
	}
	
	private MarketRatesDomain buildMarketRateDomain(MarketRateCreateRequest request) {
		MarketRatesDomain domain = new MarketRatesDomain();
		BeanUtils.copyProperties(request, domain);
		return domain;
	}

	private MarketRateResponse buildMarketRateResponse(MarketRatesDomain domain) {
		MarketRateResponse response = new MarketRateResponse();
		BeanUtils.copyProperties(domain, response);
		return response;
	}
}
