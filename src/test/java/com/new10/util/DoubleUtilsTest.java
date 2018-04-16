package com.new10.util;

import static junit.framework.Assert.assertEquals;

import com.new10.exception.New10Exception;

import org.junit.Test;

public class DoubleUtilsTest {

	@Test(expected = New10Exception.class)
	public void testWrongValueFormatToConvert() {
		final String value = "ABCD";
		DoubleUtils.stringToDouble(value);
	}

	@Test
	public void testCorrectValueFormatToConvert() {
		final String value = "100.00";
		final Double actualResult = DoubleUtils.stringToDouble(value);
		final Double expectedResult = Double.valueOf(value);
		assertEquals(expectedResult, actualResult);
	}

}
