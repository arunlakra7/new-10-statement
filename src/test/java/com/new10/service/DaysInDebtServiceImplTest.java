package com.new10.service;

import static junit.framework.Assert.assertEquals;

import com.new10.StatementGenerator;
import com.new10.xmlpojo.Stmt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class DaysInDebtServiceImplTest {

	@InjectMocks
	private DaysInDebtServiceImpl service;

	@Test
	public void testGetDaysInDebt() {
		final Stmt statement = StatementGenerator.generate("daysInDebtServiceTest.xml");
		final Integer actualResult = service.getDaysInDebt(statement);
		final Integer expectedResult = 4;
		assertEquals(expectedResult, actualResult);
	}

}
