package com.new10.util;

import static junit.framework.Assert.assertEquals;

import com.new10.exception.New10Exception;
import com.new10.pojo.YearMonthDay;

import java.time.LocalDate;

import org.junit.Test;

public class LocalDateUtilsTest {

	@Test(expected = New10Exception.class)
	public void testWrongDateFormatToConvert() {
		final String value = "ABCD";
		LocalDateUtils.stringToLocalDate(value);
	}

	@Test
	public void testCorrectDateFormatToConvert() {
		final String value = "2018-01-31";
		final LocalDate actualResult = LocalDateUtils.stringToLocalDate(value);
		final LocalDate expectedResult = LocalDate.parse(value);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMin() {
		final LocalDate localDateMin = LocalDate.parse("2017-01-31");
		final LocalDate localDateMax = LocalDate.parse("2018-01-31");
		final LocalDate actualResult = LocalDateUtils.min(localDateMin, localDateMax);
		assertEquals(localDateMin, actualResult);
	}

	@Test
	public void testTransformYearMonthDayToLocalDatet() {
		final Integer year = 2017;
		final Integer month = 12;
		final Integer day = 1;
		final YearMonthDay yearMonthDay = YearMonthDay.builder().year(year).month(month).day(day).build();
		final LocalDate actualResult = LocalDateUtils.transformYearMonthDayToLocalDate(yearMonthDay);
		final LocalDate expectedResult = LocalDate.of(year, month, day);
		assertEquals(expectedResult, actualResult);
	}
}
