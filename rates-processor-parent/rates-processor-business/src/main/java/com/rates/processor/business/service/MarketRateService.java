package com.rates.processor.business.service;

import com.rates.processor.business.dto.marketrate.MarketRateCreateRequest;
import com.rates.processor.business.dto.marketrate.MarketRateCreateResponse;
import com.rates.processor.business.dto.marketrate.MarketRateGetByIdRequest;
import com.rates.processor.business.dto.marketrate.MarketRateGetByTxnDateRequest;
import com.rates.processor.business.dto.marketrate.MarketRateResponse;

public interface MarketRateService {

	MarketRateCreateResponse createMarketRate(MarketRateCreateRequest request);
	
	MarketRateResponse getMarketRateById(MarketRateGetByIdRequest request);
	
	MarketRateResponse getMarketRateByTxnDate(MarketRateGetByTxnDateRequest request);
	
}
