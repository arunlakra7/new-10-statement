package com.new10.helper;

import static junit.framework.Assert.assertEquals;

import com.new10.support.CreditDebit;
import com.new10.xmlpojo.Amt;
import com.new10.xmlpojo.BalItem;
import com.new10.xmlpojo.Dt;
import com.new10.xmlpojo.Stmt;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StartingBalanceTest {

	@Test
	public void testExtract() {
		final Stmt statement = getStatement();
		final Double actualResult = StartingBalance.extract(statement);
		final Double expectedResult = -Double.valueOf("100.00");
		assertEquals(expectedResult, actualResult);
	}

	private Stmt getStatement() {
		final BalItem balItem1 = getBalItem("100.00", CreditDebit.DEBIT, "2017-01-31");
		final BalItem balItem2 = getBalItem("200.00", CreditDebit.CREDIT, "2018-01-31");
		final List<BalItem> balItems = Arrays.asList(balItem1, balItem2);
		return Stmt.newBuilder().withBal(balItems).build();
	}

	private BalItem getBalItem(final String value, final String cdtDbtInd, final String date) {
		final Dt dt = Dt.newBuilder().withDt(date).build();
		final Amt amt = Amt.newBuilder().withValue(value).build();
		return BalItem.newBuilder().withAmt(amt).withCdtDbtInd(cdtDbtInd).withDt(dt).build();
	}
}
