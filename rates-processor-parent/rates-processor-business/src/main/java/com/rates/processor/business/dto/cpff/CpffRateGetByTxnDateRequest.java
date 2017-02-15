package com.rates.processor.business.dto.cpff;

import java.util.Date;

public class CpffRateGetByTxnDateRequest {

	private Date transactionDate;

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	
}
