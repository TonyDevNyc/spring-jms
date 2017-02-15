package com.rates.processor.persistence.jdbc.dao.impl;

import java.sql.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.rates.processor.persistence.domain.MarketRatesDomain;
import com.rates.processor.persistence.jdbc.dao.MarketRateDao;
import com.rates.processor.persistence.jdbc.rowmappers.MarketRatesDomainRowMapper;

public class MarketRateDaoImpl extends BaseDao implements MarketRateDao {

	private static final Logger LOGGER = Logger.getLogger(MarketRateDaoImpl.class);

	private Properties marketRateQueries;

	@Override
	public Long insertMarketRate(MarketRatesDomain marketRate) {
		String sql = marketRateQueries.getProperty("insertMarketRateSql");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("rateType", marketRate.getRateType());
		params.addValue("transactionDate", marketRate.getTransactionDate());
		params.addValue("rate", marketRate.getRate());
		params.addValue("firstPercentileRate", marketRate.getFirstPercentileRate());
		params.addValue("twentyFifthPercentileRate", marketRate.getTwentyFifthPercentileRate());
		params.addValue("seventyFifthPercentileRate", marketRate.getSeventyFifthPercentileRate());
		params.addValue("ninetyNinethPercentileRate", marketRate.getNinetyNinethPercentileRate());
		params.addValue("volume", marketRate.getVolume());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParamJdbcTemplate.update(sql, params, keyHolder);

		return keyHolder.getKey().longValue();
	}

	@Override
	public MarketRatesDomain selectMarketRatesById(Long id) {
		String sql = marketRateQueries.getProperty("selectMarketRateByIdSql");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		MarketRatesDomain rate = null;
		try {
			rate = namedParamJdbcTemplate.queryForObject(sql, params, new MarketRatesDomainRowMapper());
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("No Markets Rate for id - [id=" + id + "]", e);
		}
		return rate;
	}

	@Override
	public MarketRatesDomain selectMarketRatesByTransactionDate(Date transactionDate, String rateType) {
		String sql = marketRateQueries.getProperty("selectMarketRateByTransactionDateSql");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("transactionDate", transactionDate);
		params.addValue("rateType", rateType);

		MarketRatesDomain rate = null;
		try {
			rate = namedParamJdbcTemplate.queryForObject(sql, params, new MarketRatesDomainRowMapper());
		} catch (EmptyResultDataAccessException e) {
			LOGGER.error("No Markets Rate for rateType & transactionDate - [transactionDate=" + transactionDate + "rateType="+rateType+"]", e);
		}
		return rate;
	}

	public void setMarketRateQueries(Properties marketRateQueries) {
		this.marketRateQueries = marketRateQueries;
	}

}
