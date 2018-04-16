package com.new10.pojo;

import javax.annotation.concurrent.Immutable;

import lombok.Builder;
import lombok.Data;

/**
 * A plain pojo holding properties of a monthly net balance.
 */
@Data
@Builder(toBuilder = true)
@Immutable
public final class NetBalance {

	private final Double netBalance;
	private final Integer year;
	private final Integer month;

}
