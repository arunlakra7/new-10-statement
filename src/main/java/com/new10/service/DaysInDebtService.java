package com.new10.service;

import com.new10.xmlpojo.Stmt;

/**
 * Service facilitating calculation of days in debt.
 */
public interface DaysInDebtService {

	/**
	 * Returns no of days in debt during the three most recent months of a statement.
	 * A day is under in debt when (end-of-day balance <0).
	 *
	 * @param statement bank statement to be evaluated
	 * @return no of days in debt
	 */
	Integer getDaysInDebt(Stmt statement);

}
