package com.new10.pojo;

import javax.annotation.concurrent.Immutable;

import lombok.Builder;
import lombok.Data;

/**
 * A plain pojo holding year, month and day which could be used to filter transaction based on requirements.
 */
@Data
@Builder(toBuilder = true)
@Immutable
public final class YearMonthDay {

	private final Integer year;
	private final Integer month;
	private final Integer day;

}
