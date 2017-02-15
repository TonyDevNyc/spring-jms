package com.rates.processor.business.jms.listeners;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.apache.log4j.Logger;

import com.rates.processor.business.dto.cpff.CpffRateCreateRequest;
import com.rates.processor.business.service.CpffRateService;

public class IncomingCpffRateListener implements MessageListener {

	private static final Logger LOGGER = Logger.getLogger(IncomingCpffRateListener.class);

	private CpffRateService cpffRateService;

	@Override
	public void onMessage(Message message) {
		LOGGER.info("Handling incoming Cpff Rate Message");
		
		CpffRateCreateRequest request = (CpffRateCreateRequest) ((ObjectMessage) message);
		cpffRateService.createCpffRate(request);
		
		LOGGER.info("Completed the handlding of incoming Cpff Rate Message");
	}

	public void setCpffRateService(CpffRateService cpffRateService) {
		this.cpffRateService = cpffRateService;
	}

}
