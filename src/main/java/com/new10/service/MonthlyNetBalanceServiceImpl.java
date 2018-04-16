package com.new10.service;

import com.new10.helper.DurationOfStatement;
import com.new10.helper.StartingBalance;
import com.new10.pojo.EndBalance;
import com.new10.pojo.FromDateToDate;
import com.new10.pojo.NetBalance;
import com.new10.pojo.YearMonthDay;
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
final class MonthlyNetBalanceServiceImpl implements MonthlyNetBalanceService {

	public List<NetBalance> getMonthlyNetBalance(final Stmt statement) {

		log.info("Monthly net balance calculation");
		Double startingBalance = StartingBalance.extract(statement);
		log.info("Starting balance of the bank statement {} ", startingBalance);
		final List<NtryItem> transactions = statement.getNtry();
		final FromDateToDate duration = DurationOfStatement.extract(statement);
		log.info("Duration of the bank statement {} ", duration);
		final Set<FromDateToDate> months = CalenderUtils.monthsInDuration(duration);
		log.info("No of months to calculate the net balance for {} ", months.size());
		final List<NetBalance> monthlyNetBalances = new ArrayList<>(months.size());

		for (final FromDateToDate month : months) {
			final EndBalance endBalance = EndBalanceCalculator.getEndBalanceOfMonth(month, startingBalance, transactions);
			log.info("End Balance of the duration {} is {} ", month, endBalance.getEndBalance());
			final Double netBalance = endBalance.getEndBalance() - startingBalance;
			log.info("Net Balance of the duration {} is {} ", month, netBalance);
			monthlyNetBalances.add(generateNetBalance(netBalance, endBalance));
			startingBalance = endBalance.getEndBalance();
			log.info("Starting balance of month after duration {} is {} ", month, startingBalance);
		}
		log.info("End of monthly net balance calculation");
		return monthlyNetBalances;
	}

	private NetBalance generateNetBalance(final Double netBalance, final EndBalance endBalance) {
		final YearMonthDay yearMonthDay = endBalance.getYearMonthDay();
		return NetBalance.builder().netBalance(netBalance).year(yearMonthDay.getYear()).month(yearMonthDay.getMonth()).build();
	}
}
