package com.rates.processor.business.dto.marketrate;

import java.math.BigDecimal;
import java.util.Date;

public class MarketRateResponse {

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

	public void setTwentyFifthPercentileRate(BigDecimal twentyFifthPercentileRate) {
		this.twentyFifthPercentileRate = twentyFifthPercentileRate;
	}

	public BigDecimal getSeventyFifthPercentileRate() {
		return seventyFifthPercentileRate;
	}

	public void setSeventyFifthPercentileRate(BigDecimal seventyFifthPercentileRate) {
		this.seventyFifthPercentileRate = seventyFifthPercentileRate;
	}

	public BigDecimal getNinetyNinethPercentileRate() {
		return ninetyNinethPercentileRate;
	}

	public void setNinetyNinethPercentileRate(BigDecimal ninetyNinethPercentileRate) {
		this.ninetyNinethPercentileRate = ninetyNinethPercentileRate;
	}

	public BigDecimal getVolume() {
		return volume;
	}

	public void setVolume(BigDecimal volume) {
		this.volume = volume;
	}

}
