package com.new10.helper;

import static junit.framework.Assert.assertEquals;

import com.new10.support.CreditDebit;

import org.junit.Test;

public class AmountBasedOnCreditOrDebitTest {

	private Double amount = Double.valueOf("100");

	@Test
	public void extract_returns_negative_value() {
		final String cdtDbtInd = CreditDebit.DEBIT;
		final Double actualResult = AmountBasedOnCreditOrDebit.extract(amount, cdtDbtInd);
		final Double expectedResult = -amount;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void extract_returns_positive_value() {
		final String cdtDbtInd = CreditDebit.CREDIT;
		final Double actualResult = AmountBasedOnCreditOrDebit.extract(amount, cdtDbtInd);
		final Double expectedResult = amount;
		assertEquals(expectedResult, actualResult);
	}
}
