package com.new10.helper;

import static junit.framework.Assert.assertEquals;

import com.new10.pojo.FromDateToDate;
import com.new10.util.LocalDateUtils;
import com.new10.xmlpojo.FrToDt;
import com.new10.xmlpojo.Stmt;

import java.time.LocalDate;

import org.junit.Test;

public class DurationOfDailyDebtsTest {

	private String fromDate = "2018-01-31";

	@Test
	public void testExtract() {
		final Stmt statement = getStatement();
		final Integer noOfHistoricMonths = 3;
		final FromDateToDate actualResult = DurationOfDailyDebts.extract(statement, noOfHistoricMonths);
		final LocalDate expectedFromDate = LocalDateUtils.stringToLocalDate(fromDate).minusMonths(3);
		final LocalDate expectedToDate = LocalDateUtils.stringToLocalDate(fromDate);
		final FromDateToDate expectedResult = FromDateToDate.builder().fromDate(expectedFromDate).toDate(expectedToDate).build();
		assertEquals(expectedResult, actualResult);
	}

	private Stmt getStatement() {
		final FrToDt frToDt = FrToDt.newBuilder().withFrDtTm(fromDate).build();
		return Stmt.newBuilder().withFrToDt(frToDt).build();
	}
}
