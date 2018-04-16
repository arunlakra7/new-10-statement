package com.new10.util;

import com.new10.exception.New10Exception;
import com.new10.exception.New10Reason;
import com.new10.pojo.YearMonthDay;

import java.time.LocalDate;

public final class LocalDateUtils {

	/**
	 * Converts value as a string to LocalDate
	 *
	 * @param value value to converted
	 * @throws New10Exception when not a supported format
	 */
	public static LocalDate stringToLocalDate(String value) {
		try {
			return LocalDate.parse(value);
		} catch (final Exception e) {
			throw new New10Exception(New10Reason.INVALID_DATE_FORMAT, "Requested date format : '" + value + "' is invalid");
		}
	}

	/**
	 * @param date1 local date one
	 * @param date2 local date two
	 * @return date1 if (date1 < date2)
	 */
	public static LocalDate min(final LocalDate date1, final LocalDate date2) {
		return date1.isBefore(date2) ? date1 : date2;
	}

	/**
	 * Converts YearMonthDay to LocalDate
	 *
	 * @param yearMonthDay object to converted
	 */
	public static LocalDate transformYearMonthDayToLocalDate(final YearMonthDay yearMonthDay) {
		final Integer year = yearMonthDay.getYear();
		final Integer month = yearMonthDay.getMonth();
		final Integer day = yearMonthDay.getDay();
		return LocalDate.of(year, month, day);
	}

}
