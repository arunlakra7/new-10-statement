package com.new10.pojo;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class EndBalanceTest {

	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.forClass(EndBalance.class).allFieldsShouldBeUsed().verify();
	}
}
