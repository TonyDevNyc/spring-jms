package com.rates.processor.persistence.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rates.processor.persistence.domain.MarketRatesDomain;

public class MarketRatesDomainRowMapper implements RowMapper<MarketRatesDomain> {

	@Override
	public MarketRatesDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return null;
	}

}
