package com.rates.processor.persistence.jdbc.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rates.processor.persistence.domain.CpffRateDomain;

public class CpffRateDomainRowMapper implements RowMapper<CpffRateDomain> {

	@Override
	public CpffRateDomain mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return null;
	}

}
