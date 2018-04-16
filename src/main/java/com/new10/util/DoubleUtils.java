package com.new10.util;

import com.new10.exception.New10Exception;
import com.new10.exception.New10Reason;

public final class DoubleUtils {

	/**
	 * Converts value as a string to Double
	 *
	 * @param value value to converted
	 * @throws New10Exception when not a supported format
	 */
	public static Double stringToDouble(final String value) {
		try {
			return Double.parseDouble(value);
		} catch (final Exception e) {
			throw new New10Exception(New10Reason.INVALID_AMOUNT, "Requested amount : '" + value + "' is invalid");
		}
	}
}
