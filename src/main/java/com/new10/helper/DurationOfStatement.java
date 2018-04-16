package com.new10.helper;

import com.new10.pojo.FromDateToDate;
import com.new10.util.LocalDateUtils;
import com.new10.xmlpojo.Stmt;

import java.time.LocalDate;

/**
 * Returns the duration of a bank statement.
 */
public final class DurationOfStatement {

	private DurationOfStatement() {
		// no pubic constructor
	}

	/**
	 * Returns the duration of a bank statement.
	 *
	 * @param statement bank statement
	 * @return {@link FromDateToDate}
	 */
	public static FromDateToDate extract(final Stmt statement) {
		final LocalDate fromDate = LocalDateUtils.stringToLocalDate(statement.getFrToDt().getToDtTm());
		final LocalDate toDate = LocalDateUtils.stringToLocalDate(statement.getFrToDt().getFrDtTm());
		return FromDateToDate.builder().fromDate(fromDate).toDate(toDate).build();
	}
}
