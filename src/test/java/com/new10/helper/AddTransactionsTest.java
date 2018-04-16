package com.new10.helper;

import static junit.framework.Assert.assertEquals;

import com.new10.support.CreditDebit;
import com.new10.util.DoubleUtils;
import com.new10.xmlpojo.Amt;
import com.new10.xmlpojo.NtryItem;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AddTransactionsTest {

	private List<NtryItem> transactions;
	private String creditValue1 = "100.00";
	private String creditValue2 = "200.00";

	@Before
	public void setUp() {
		final NtryItem transactions1 = generateTransaction(CreditDebit.CREDIT, creditValue1);
		final NtryItem transactions2 = generateTransaction(CreditDebit.CREDIT, creditValue2);
		transactions = Arrays.asList(transactions1, transactions2);
	}

	@Test
	public void addReturnsZero() {
		final String cdtDbtInd = CreditDebit.DEBIT;
		final Double actualResult = AddTransactions.add(cdtDbtInd, transactions);
		final Double expectedResult = AddTransactions.ZERO;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void addReturnsSum() {
		final String cdtDbtInd = CreditDebit.CREDIT;
		final Double actualResult = AddTransactions.add(cdtDbtInd, transactions);
		final Double expectedResult = DoubleUtils.stringToDouble(creditValue1) + DoubleUtils.stringToDouble(creditValue2);
		assertEquals(expectedResult, actualResult);
	}

	private NtryItem generateTransaction(final String cdtDbtInd, final String value) {
		final Amt amt = Amt.newBuilder().withValue(value).build();
		return NtryItem.newBuilder().withAmt(amt).withCdtDbtInd(cdtDbtInd).build();
	}
}
