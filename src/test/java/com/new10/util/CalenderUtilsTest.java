package com.new10.util;

import static junit.framework.Assert.assertEquals;

import com.google.common.collect.Sets;
import com.new10.pojo.FromDateToDate;

import java.time.LocalDate;
import java.util.Set;

import org.junit.Test;

public class CalenderUtilsTest {

	@Test
	public void testMonthsInDuration() {

		final LocalDate fromDate = LocalDate.of(2017, 1, 1);
		final LocalDate toDate = LocalDate.of(2017, 3, 15);
		final Set<FromDateToDate> actualResult = CalenderUtils.monthsInDuration(FromDateToDate.builder().fromDate(fromDate).toDate(toDate).build());

		final FromDateToDate monthOne = FromDateToDate.builder().fromDate(LocalDate.of(2017, 1, 1)).toDate(LocalDate.of(2017, 2, 1)).build();
		final FromDateToDate monthTwo = FromDateToDate.builder().fromDate(LocalDate.of(2017, 2, 1)).toDate(LocalDate.of(2017, 3, 1)).build();
		final FromDateToDate monthThree = FromDateToDate.builder().fromDate(LocalDate.of(2017, 3, 1)).toDate(LocalDate.of(2017, 3, 15)).build();

		final Set<FromDateToDate> expectedResult = Sets.newHashSet(monthOne, monthTwo, monthThree);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testDaysInDuration() {

		final LocalDate fromDate = LocalDate.of(2017, 1, 1);
		final LocalDate toDate = LocalDate.of(2017, 1, 3);
		final Set<FromDateToDate> actualResult = CalenderUtils.daysInDuration(FromDateToDate.builder().fromDate(fromDate).toDate(toDate).build());

		final FromDateToDate dayOne = FromDateToDate.builder().fromDate(LocalDate.of(2017, 1, 1)).toDate(LocalDate.of(2017, 1, 2)).build();
		final FromDateToDate dayTwo = FromDateToDate.builder().fromDate(LocalDate.of(2017, 1, 2)).toDate(LocalDate.of(2017, 1, 3)).build();
		final FromDateToDate dayThree = FromDateToDate.builder().fromDate(LocalDate.of(2017, 1, 3)).toDate(LocalDate.of(2017, 1, 4)).build();

		final Set<FromDateToDate> expectedResult = Sets.newHashSet(dayOne, dayTwo, dayThree);
		assertEquals(expectedResult, actualResult);
	}
}
