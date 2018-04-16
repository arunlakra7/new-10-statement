package com.new10.service;

import com.google.common.collect.FluentIterable;
import com.new10.helper.AddTransactions;
import com.new10.pojo.EndBalance;
import com.new10.pojo.FromDateToDate;
import com.new10.support.CreditDebit;
import com.new10.support.yearmonthday.WithYearMonthDays;
import com.new10.xmlpojo.NtryItem;

import java.util.List;

/**
 * A calculator to get an end balance which could be monthly or daily. Behaves as desired only if consumed by {@link
 * DaysInDebtService#getDaysInDebt(com.new10.xmlpojo.Stmt)} or {@link MonthlyNetBalanceService#getMonthlyNetBalance(com.new10.xmlpojo.Stmt)}. Hence
 * given on public access.
 */
final class EndBalanceCalculator {

	/**
	 * Returns end balance of a month.
	 * End balance of a month = starting balance of that month + (credit transactions in that month - debit transactions in that month)
	 *
	 * @param duration        {@link FromDateToDate} holding duration of the month
	 * @param startingBalance starting balance of the month
	 * @param transactions    all the transactions of a statement
	 * @return {@link EndBalance}
	 */
	static EndBalance getEndBalanceOfMonth(final FromDateToDate duration, final Double startingBalance, final List<NtryItem> transactions) {

		final List<NtryItem> transactionsOfMonth = FluentIterable.from(transactions)
			.filter((final NtryItem item) -> {
				return WithYearMonthDays.yearMonthMatcher(item.getYearMonthDay(), duration.getYearMonthDay());
			})
			.toList();
		final Double endBalanceValue = getEndBalanceValue(startingBalance, transactionsOfMonth);
		return EndBalance.builder().endBalance(endBalanceValue).fromDateToDate(duration).build();
	}

	/**
	 * Returns end balance of a day. End balance of a day =
	 * starting balance of that day + (credit transactions in that day - debit transactions in that day)
	 *
	 * @param duration        {@link FromDateToDate} holding duration of the day
	 * @param startingBalance starting balance of the day
	 * @param transactions    all the transactions of a statement
	 * @return {@link EndBalance}
	 */
	static EndBalance getDailyEndBalance(final FromDateToDate duration, final Double startingBalance, final List<NtryItem> transactions) {
		final List<NtryItem> transactionsOfDay = FluentIterable.from(transactions)
			.filter((final NtryItem item) -> {
				return WithYearMonthDays.matcher(item.getYearMonthDay(), duration.getYearMonthDay());
			})
			.toList();
		final Double endBalanceValue = getEndBalanceValue(startingBalance, transactionsOfDay);
		return EndBalance.builder().endBalance(endBalanceValue).fromDateToDate(duration).build();
	}

	private static Double getEndBalanceValue(final Double startingBalance, final List<NtryItem> transactionsOfMonth) {
		final Double credits = AddTransactions.add(CreditDebit.CREDIT, transactionsOfMonth);
		final Double debits = AddTransactions.add(CreditDebit.DEBIT, transactionsOfMonth);
		return startingBalance + (credits - debits);
	}

}
