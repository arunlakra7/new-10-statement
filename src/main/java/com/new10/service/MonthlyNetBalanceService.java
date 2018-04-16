package com.new10.service;

import com.new10.pojo.NetBalance;
import com.new10.xmlpojo.Stmt;

import java.util.List;

/**
 * Service facilitating calculation of monthly net balance.
 */
public interface MonthlyNetBalanceService {

	/**
	 * Returns monthly net balance of months present in a bank statement.
	 * Net balance for a month = (endBalance - startingBalance).
	 *
	 * @param statement bank statement to be evaluated
	 * @return a list of {@link NetBalance}
	 */
	List<NetBalance> getMonthlyNetBalance(Stmt statement);

}
