package com.new10.pojo;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class YearMonthDayTest {

	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.forClass(YearMonthDay.class).allFieldsShouldBeUsed().verify();
	}
}
