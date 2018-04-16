package com.new10.service;

import com.google.common.collect.FluentIterable;
import com.new10.helper.DurationOfDailyDebts;
import com.new10.helper.DurationOfStatement;
import com.new10.helper.StartingBalance;
import com.new10.pojo.EndBalance;
import com.new10.pojo.FromDateToDate;
import com.new10.support.yearmonthday.WithYearMonthDays;
import com.new10.util.CalenderUtils;
import com.new10.xmlpojo.NtryItem;
import com.new10.xmlpojo.Stmt;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
final class DaysInDebtServiceImpl implements DaysInDebtService {

	private static final int NO_OF_RECENT_MONTHS = 3;

	public Integer getDaysInDebt(final Stmt statement) {

		log.info("No of days in debt calculation");
		Double startingBalance = StartingBalance.extract(statement);
		log.info("Starting balance of the bank statement {} ", startingBalance);
		final List<NtryItem> transactions = statement.getNtry();
		final FromDateToDate durationOfStatement = DurationOfStatement.extract(statement);
		log.info("Duration of the bank statement {} ", durationOfStatement);
		final Set<FromDateToDate> daysInStatement = CalenderUtils.daysInDuration(durationOfStatement);
		log.info("No of days in the statement {} ", daysInStatement.size());

		// a list of end balance of every day present in the statement
		final List<EndBalance> dailyEndBalances = new ArrayList<>(daysInStatement.size());

		for (final FromDateToDate dayInStatement : daysInStatement) {
			final EndBalance endBalance = EndBalanceCalculator.getDailyEndBalance(dayInStatement, startingBalance, transactions);
			log.info("End Balance of the duration {} is {} ", dayInStatement, endBalance.getEndBalance());
			dailyEndBalances.add(endBalance);
			startingBalance = endBalance.getEndBalance();
			log.info("Starting balance of day after duration {} is {} ", dayInStatement, startingBalance);
		}
		return getNumberOfDaysUnderDebt(statement, dailyEndBalances);

	}

	private Integer getNumberOfDaysUnderDebt(final Stmt statement, final List<EndBalance> dailyEndBalances) {

		// get duration and days of desired recent months which in this case is NO_OF_RECENT_MONTHS.
		final FromDateToDate durationToEvaluateForDebt = DurationOfDailyDebts.extract(statement, NO_OF_RECENT_MONTHS);
		log.info("Duration to evaluate for debt {} ", durationToEvaluateForDebt);
		final Set<FromDateToDate> daysToEvaluateForDebt = CalenderUtils.daysInDuration(durationToEvaluateForDebt);
		log.info("No of days to evaluate for debt {} ", daysToEvaluateForDebt.size());

		return FluentIterable.from(dailyEndBalances)						// end balance of all days in statement
			.filter(WithYearMonthDays.matcher(daysToEvaluateForDebt))		// only get the end balances of days to be evaluated
			.filter((final EndBalance item) -> item.getEndBalance() < 0)    // only consider days when end balance was less than zero
			.size();
	}
}
