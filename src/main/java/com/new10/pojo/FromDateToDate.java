package com.new10.pojo;

import com.new10.support.yearmonthday.WithYearMonthDay;

import java.time.LocalDate;

import javax.annotation.concurrent.Immutable;

import lombok.Builder;
import lombok.Data;

/**
 * A plain pojo holding from date and to date which combined forms duration of a day, month or a year based on parameter passed.
 */
@Data
@Builder(toBuilder = true)
@Immutable
public final class FromDateToDate implements WithYearMonthDay {

	private final LocalDate fromDate;
	private final LocalDate toDate;

	@Override
	public YearMonthDay getYearMonthDay() {
		return new YearMonthDay(fromDate.getYear(), fromDate.getMonthValue(), fromDate.getDayOfMonth());
	}
}
