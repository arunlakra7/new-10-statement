package com.new10.pojo;

import com.google.common.base.Objects;
import com.new10.support.yearmonthday.WithYearMonthDay;

import java.time.LocalDate;

import javax.annotation.concurrent.Immutable;

import lombok.Builder;
import lombok.Data;

/**
 * A plain pojo holding properties of an end balance.
 */
@Data
@Builder(toBuilder = true)
@Immutable
public final class EndBalance implements WithYearMonthDay {

	private final Double endBalance;
	private final FromDateToDate fromDateToDate;

	@Override
	public YearMonthDay getYearMonthDay() {
		final LocalDate fromDate = fromDateToDate.getFromDate();
		return new YearMonthDay(fromDate.getYear(), fromDate.getMonthValue(), fromDate.getDayOfMonth());
	}
}
