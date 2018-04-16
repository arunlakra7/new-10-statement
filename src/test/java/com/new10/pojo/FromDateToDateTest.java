package com.new10.pojo;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class FromDateToDateTest {

	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.forClass(FromDateToDate.class).allFieldsShouldBeUsed().verify();
	}
}
