package com.rates.processor.persistence.jdbc.dao.impl;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;

public class BaseDao {

	protected NamedParameterJdbcOperations namedParamJdbcTemplate;

	public void setNamedParamJdbcTemplate(NamedParameterJdbcOperations namedParamJdbcTemplate) {
		this.namedParamJdbcTemplate = namedParamJdbcTemplate;
	}

}
