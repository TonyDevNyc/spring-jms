package com.rates.processor.persistence.jdbc.dao;

import java.sql.Date;

import com.rates.processor.persistence.domain.CpffRateDomain;

public interface CpffRateDao {

	Long insertCpffRateDomain(CpffRateDomain cpffRate);

	CpffRateDomain selectCpffRateById(Long id);

	CpffRateDomain selectCpffRateByTransactionDate(Date transactionDate);

}
