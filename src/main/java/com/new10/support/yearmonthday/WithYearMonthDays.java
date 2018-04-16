package com.new10.support.yearmonthday;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.new10.pojo.YearMonthDay;
import com.new10.util.LocalDateUtils;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;

import javax.annotation.Nullable;

import org.springframework.util.Assert;

/**
 * A utility class to do operations based on year, month or day of properties of a statement.
 */
public final class WithYearMonthDays {

	/**
	 * Returns a {@link Comparator} that sorts element based on its year, month, and day.
	 */
	public static Comparator<? super WithYearMonthDay> comparator() {
		return new YearMonthDayComparator();
	}

	/**
	 * Returns a {@link com.google.common.base.Predicate} that matches the given collection of WithYearMonthDay.
	 *
	 * @param elements - Collection of WithYearMonthDay to match.
	 * @return - A predicate matching the given collection of WithYearMonth.
	 */
	public static Predicate<? super WithYearMonthDay> matcher(final Collection<? extends WithYearMonthDay> elements) {
		return new Matcher(FluentIterable.from(elements).transform(new Transformer()).toList());
	}

	/**
	 * @return true if given objects are equal.
	 */
	public static boolean matcher(final YearMonthDay o1, final YearMonthDay o2) {
		return o1.equals(o2);
	}

	/**
	 * @return true if only year and month of given objects are equal.
	 */
	public static boolean yearMonthMatcher(final YearMonthDay o1, final YearMonthDay o2) {
		return o1.getMonth().equals(o2.getMonth()) && o1.getYear().equals(o2.getYear());
	}

	/**
	 * Transformer implementation.
	 */
	private static final class Transformer implements Function<WithYearMonthDay, YearMonthDay> {

		@Override
		public YearMonthDay apply(@Nullable final WithYearMonthDay input) {
			Assert.notNull(input, "");
			return input.getYearMonthDay();
		}
	}

	/**
	 * Comparator implementation.
	 */
	private static final class YearMonthDayComparator implements Comparator<WithYearMonthDay> {

		@Override
		public int compare(final WithYearMonthDay o1, final WithYearMonthDay o2) {
			Assert.notNull(o1, "");
			Assert.notNull(o2, "");
			final LocalDate localDate1 = LocalDateUtils.transformYearMonthDayToLocalDate(o1.getYearMonthDay());
			final LocalDate localDate2 = LocalDateUtils.transformYearMonthDayToLocalDate(o2.getYearMonthDay());
			return localDate1.compareTo(localDate2);
		}
	}

	/**
	 * Matcher implementation
	 */
	private static final class Matcher implements Predicate<WithYearMonthDay> {
		private final Collection<YearMonthDay> elements;

		private Matcher(Collection<YearMonthDay> elements) {
			this.elements = elements;
		}

		@Override
		public boolean apply(@Nullable final WithYearMonthDay input) {
			Assert.notNull(input, "");
			return elements.contains(input.getYearMonthDay());
		}
	}

}
