package com.new10.helper;

import com.new10.support.CreditDebit;

public final class AmountBasedOnCreditOrDebit {

	/**
	 * Returns amount based on credit or debit indicator.
	 *
	 * @param amount    amount to be evaluated
	 * @param cdtDbtInd Credit, Debit
	 * @return given amount in negative if Debit and vice-versa.
	 */
	public static Double extract(final Double amount, final String cdtDbtInd) {
		if (cdtDbtInd.equals(CreditDebit.CREDIT)) {
			return amount;
		}
		return -amount;
	}
}
