package com.new10.exception;

/**
 * An enum holding reasons for an exception.
 */
public enum New10Reason implements Reason {

	INVALID_DATE_FORMAT,
	INVALID_AMOUNT,
	XML_PARSING_EXCEPTION;

	@Override
	public String getCode() {
		return name();
	}
}
