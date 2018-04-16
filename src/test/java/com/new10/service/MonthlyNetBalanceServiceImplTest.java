package com.new10.service;

import static junit.framework.Assert.assertEquals;

import com.new10.StatementGenerator;
import com.new10.pojo.NetBalance;
import com.new10.xmlpojo.Stmt;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MonthlyNetBalanceServiceImplTest {

	@InjectMocks
	private MonthlyNetBalanceServiceImpl service;

	@Test
	public void testGetMonthlyNetBalance() {
		final Stmt statement = StatementGenerator.generate("monthlyNetBalanceServiceTest.xml");
		final List<NetBalance> actualResult = service.getMonthlyNetBalance(statement);
		final NetBalance expectedNetBalance1 = generateNetBalance(-Double.valueOf("100.00"), 2018, 1);
		final NetBalance expectedNetBalance2 = generateNetBalance(-Double.valueOf("150.00"), 2018, 2);
		final NetBalance expectedNetBalance3 = generateNetBalance(-Double.valueOf("200.00"), 2018, 3);
		final List<NetBalance> expectedResult = Arrays.asList(expectedNetBalance1, expectedNetBalance2, expectedNetBalance3);
		assertEquals(expectedResult, actualResult);
	}

	private NetBalance generateNetBalance(final Double netBalance, final Integer year, final Integer month) {
		return NetBalance.builder().netBalance(netBalance).year(year).month(month).build();
	}

}
