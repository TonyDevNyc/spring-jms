package com.rates.processor.business.service;

import com.rates.processor.business.dto.cpff.CpffRateCreateRequest;
import com.rates.processor.business.dto.cpff.CpffRateCreateResponse;
import com.rates.processor.business.dto.cpff.CpffRateGetByIdRequest;
import com.rates.processor.business.dto.cpff.CpffRateGetByTxnDateRequest;
import com.rates.processor.business.dto.cpff.CpffRateResponse;

public interface CpffRateService {

	CpffRateCreateResponse createCpffRate(CpffRateCreateRequest request);

	CpffRateResponse getCpffRateById(CpffRateGetByIdRequest request);

	CpffRateResponse getCpffRateByTxnDate(CpffRateGetByTxnDateRequest request);

}
