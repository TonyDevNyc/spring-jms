package com.rates.processor.persistence.jdbc.dao.impl;

import java.sql.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.rates.processor.persistence.domain.CpffRateDomain;
import com.rates.processor.persistence.jdbc.dao.CpffRateDao;
import com.rates.processor.persistence.jdbc.rowmappers.CpffRateDomainRowMapper;

public class CpffRateDaoImpl extends BaseDao implements CpffRateDao {

	private static final Logger LOGGER = Logger.getLogger(CpffRateDaoImpl.class);

	private Properties cpffRateQueries;

	@Override
	public Long insertCpffRateDomain(CpffRateDomain cpffRate) {
		String sql = cpffRateQueries.getProperty("insertCpffRateSql");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("transactionDate", cpffRate.getTransactionDate());
		params.addValue("unsecuredDate", cpffRate.getUnsecuredRate());
		params.addValue("securedDate", cpffRate.getSecuredRate());
		params.addValue("maturityDate", cpffRate.getMaturityDate());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParamJdbcTemplate.update(sql, params, keyHolder);

		return keyHolder.getKey().longValue();
	}

	@Override
	public CpffRateDomain selectCpffRateById(Long id) {
		String sql = cpffRateQueries.getProperty("insertCpffRateSql");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		CpffRateDomain rate = null;
		try {
			rate = namedParamJdbcTemplate.queryForObject(sql, params, new CpffRateDomainRowMapper());
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("No CPFF rate for id - [id=" + id + "]", e);
		}
		return rate;
	}

	@Override
	public CpffRateDomain selectCpffRateByTransactionDate(Date transactionDate) {
		String sql = cpffRateQueries.getProperty("selectCpffRateByTransactionDateSql");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("transactionDate", transactionDate);

		CpffRateDomain rate = null;
		try {
			rate = namedParamJdbcTemplate.queryForObject(sql, params, new CpffRateDomainRowMapper());
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("No CPFF rate for transactionDate - [transactionDate=" + transactionDate + "]", e);
		}
		return rate;
	}

	public void setCpffRateQueries(Properties cpffRateQueries) {
		this.cpffRateQueries = cpffRateQueries;
	}

}
