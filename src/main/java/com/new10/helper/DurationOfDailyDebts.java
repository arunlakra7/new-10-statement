package com.new10.helper;

import com.new10.pojo.FromDateToDate;
import com.new10.util.LocalDateUtils;
import com.new10.xmlpojo.Stmt;

import java.time.LocalDate;

/**
 * Returns the duration required to evaluate no of days in debt.
 */
public final class DurationOfDailyDebts {

	private DurationOfDailyDebts() {
		// no pubic constructor
	}

	/**
	 * Returns the duration required to evaluate no of days in debt.
	 *
	 * @param statement        bank statement
	 * @param noOfRecentMonths number of recent months required to evaluate
	 * @return {@link FromDateToDate}
	 */
	public static FromDateToDate extract(final Stmt statement, final Integer noOfRecentMonths) {
		final LocalDate lastDateOfBankStatement = LocalDateUtils.stringToLocalDate(statement.getFrToDt().getFrDtTm());
		final LocalDate fromDate = lastDateOfBankStatement.minusMonths(noOfRecentMonths);
		return FromDateToDate.builder().fromDate(fromDate).toDate(lastDateOfBankStatement).build();
	}
}
