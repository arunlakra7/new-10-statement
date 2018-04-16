package com.new10.helper;

import com.google.common.collect.FluentIterable;
import com.new10.support.yearmonthday.WithYearMonthDays;
import com.new10.xmlpojo.BalItem;
import com.new10.xmlpojo.Stmt;

import java.util.List;

public final class StartingBalance {

	private StartingBalance() {
		// no pubic constructor
	}

	/**
	 * Returns starting balance of a statement.
	 *
	 * @param statement statement to be evaluated
	 */
	public static Double extract(final Stmt statement) {
		final List<BalItem> balanceItems = statement.getBal();
		balanceItems.sort(WithYearMonthDays.comparator());
		final BalItem startingBalanceItem = FluentIterable.from(balanceItems).first().get();
		return AmountBasedOnCreditOrDebit.extract(startingBalanceItem.getAmt().getValueAsDouble(), startingBalanceItem.getCdtDbtInd());
	}
}
