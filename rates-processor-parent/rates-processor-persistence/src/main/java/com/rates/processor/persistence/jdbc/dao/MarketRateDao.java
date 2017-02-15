package com.rates.processor.persistence.jdbc.dao;

import java.sql.Date;

import com.rates.processor.persistence.domain.MarketRatesDomain;

public interface MarketRateDao {

	Long insertMarketRate(MarketRatesDomain marketRate);

	MarketRatesDomain selectMarketRatesById(Long id);

	MarketRatesDomain selectMarketRatesByTransactionDate(Date transactionDate, String rateType);

}
