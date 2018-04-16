package com.new10.exception;

/**
 * A simple custom exception class.
 */
public final class New10Exception extends RuntimeException {

	private final New10Reason reason;

	public New10Exception(final New10Reason reason, final String message) {
		super(message);
		this.reason = reason;
	}

	public New10Reason getReason() {
		return reason;
	}
}
