package com.rates.processor.business.dto.cpff;

import java.math.BigDecimal;
import java.sql.Date;

public class CpffRateCreateRequest {

	private Date transactionDate;
	private BigDecimal unsecuredRate;
	private BigDecimal securedRate;
	private Date maturityDate;

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getUnsecuredRate() {
		return unsecuredRate;
	}

	public void setUnsecuredRate(BigDecimal unsecuredRate) {
		this.unsecuredRate = unsecuredRate;
	}

	public BigDecimal getSecuredRate() {
		return securedRate;
	}

	public void setSecuredRate(BigDecimal securedRate) {
		this.securedRate = securedRate;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

}
