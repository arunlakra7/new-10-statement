package com.new10.pojo;

import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.Test;

public class NetBalanceTest {

	@Test
	public void testEqualsAndHashCode() {
		EqualsVerifier.forClass(NetBalance.class).allFieldsShouldBeUsed().verify();
	}
}
