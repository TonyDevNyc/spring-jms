package com.rates.processor.persistence.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class CpffRateDomain {

	private Long id;
	private Date transactionDate;
	private BigDecimal unsecuredRate;
	private BigDecimal securedRate;
	private Date maturityDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpffRateDomain other = (CpffRateDomain) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
