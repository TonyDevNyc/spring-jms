package com.rates.processor.persistence.domain;

import java.math.BigDecimal;
import java.sql.Date;

public class MarketRatesDomain {

	private Long id;
	private String rateType;
	private Date transactionDate;
	private BigDecimal rate;
	private BigDecimal firstPercentileRate;
	private BigDecimal twentyFifthPercentileRate;
	private BigDecimal seventyFifthPercentileRate;
	private BigDecimal ninetyNinethPercentileRate;
	private BigDecimal volume;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public BigDecimal getFirstPercentileRate() {
		return firstPercentileRate;
	}

	public void setFirstPercentileRate(BigDecimal firstPercentileRate) {
		this.firstPercentileRate = firstPercentileRate;
	}

	public BigDecimal getTwentyFifthPercentileRate() {
		return twentyFifthPercentileRate;
	}

	public void setTwentyFifthPercentileRate(
			BigDecimal twentyFifthPercentileRate) {
		this.twentyFifthPercentileRate = twentyFifthPercentileRate;
	}

	public BigDecimal getSeventyFifthPercentileRate() {
		return seventyFifthPercentileRate;
	}

	public void setSeventyFifthPercentileRate(
			BigDecimal seventyFifthPercentileRate) {
		this.seventyFifthPercentileRate = seventyFifthPercentileRate;
	}

	public BigDecimal getNinetyNinethPercentileRate() {
		return ninetyNinethPercentileRate;
	}

	public void setNinetyNinethPercentileRate(
			BigDecimal ninetyNinethPercentileRate) {
		this.ninetyNinethPercentileRate = ninetyNinethPercentileRate;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
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
		MarketRatesDomain other = (MarketRatesDomain) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
