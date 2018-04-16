package com.new10.util;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.Sets;
import com.new10.pojo.FromDateToDate;
import com.new10.support.yearmonthday.WithYearMonthDays;

import java.time.LocalDate;
import java.util.Set;

public final class CalenderUtils {

	private static final int ONE = 1;
	private static final int FIRST_DAY_OF_MONTH = 1;

	// private constructor.
	private CalenderUtils() {
	}

	/**
	 * Returns a set of months present under the given duration. For instance, months b/w duration 1-JAN-2017 to 15-MAR-2017 will be :
	 * <p>
	 * 		<li>[1-JAN-2017 - 1-FEB-2017)</li>
	 * 		<li>[1-FEB-2017 - 1-MAR-2017)</li>
	 * 		<li>[1-MAR-2017 - 15-MAR-2017)</li>
	 * </p>
	 */
	public static Set<FromDateToDate> monthsInDuration(final FromDateToDate duration) {
		return getSetOfDuration(duration, true);
	}

	/**
	 * Returns a set of days present under the given duration. For instance, days b/w duration 1-JAN-2017 to 3-JAN-2017 will be :
	 * <p>
	 * 		<li>[1-JAN-2017 - 2-JAN-2017)</li>
	 * 		<li>[2-JAN-2017 - 3-MAR-2017)</li>
	 * 		<li>[3-JAN-2017 - 4-MAR-2017)</li>
	 * </p>
	 */
	public static Set<FromDateToDate> daysInDuration(final FromDateToDate duration) {
		final Set<FromDateToDate> result = Sets.newHashSet();
		final Set<FromDateToDate> daysInDurationExcludingLastDay = getSetOfDuration(duration, false);
		final FromDateToDate lastDay = FromDateToDate.builder().fromDate(duration.getToDate()).toDate(duration.getToDate().plusDays(ONE)).build();
		result.addAll(daysInDurationExcludingLastDay);
		result.add(lastDay);
		return FluentIterable.from(result).toSortedSet(WithYearMonthDays.comparator());
	}

	private static Set<FromDateToDate> getSetOfDuration(final FromDateToDate duration, final boolean durationInMonths) {
		final Set<FromDateToDate> result = Sets.newHashSet();

		LocalDate fromDate = duration.getFromDate();
		final LocalDate toDate = duration.getToDate();

		while (fromDate.isBefore(toDate)) {
			LocalDate rangeEndDate = fromDate.plusDays(ONE);
			if (durationInMonths) {
				rangeEndDate = LocalDateUtils.min(fromDate.plusMonths(ONE).withDayOfMonth(FIRST_DAY_OF_MONTH), toDate);
			}
			result.add(FromDateToDate.builder().fromDate(fromDate).toDate(rangeEndDate).build());
			fromDate = rangeEndDate;
		}
		return FluentIterable.from(result).toSortedSet(WithYearMonthDays.comparator());
	}
}
