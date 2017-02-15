package com.rates.processor.business.dto.marketrate;

import java.util.Date;

public class MarketRateGetByTxnDateRequest {

	private Date transactionDate;
	
	private String rateType;

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

}
