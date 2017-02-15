package com.rates.processor.business;

import java.util.Date;

public final class DateUtils {

	private DateUtils() { }
	
	public static java.sql.Date convertToSqlDate(Date date) {
		if (date == null) {
			return null;
		}
		
		return new java.sql.Date(date.getTime());
	}
}
