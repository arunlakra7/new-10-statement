package com.new10.controller;

import com.new10.pojo.NetBalance;
import com.new10.service.DaysInDebtService;
import com.new10.service.MonthlyNetBalanceService;
import com.new10.xmlpojo.Document;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/statement")
public class New10Controller {

	private final MonthlyNetBalanceService monthlyNetBalanceService;
	private final DaysInDebtService daysInDebtService;

	@Autowired
	public New10Controller(final MonthlyNetBalanceService monthlyNetBalanceService, final DaysInDebtService daysInDebtService) {
		this.monthlyNetBalanceService = monthlyNetBalanceService;
		this.daysInDebtService = daysInDebtService;
	}

	/**
	 * A simple POST rest end point responsible for consuming an xml document and returning monthly net balance.
	 *
	 * @param document consumed xml document
	 * @return a list of {@link NetBalance}
	 */
	@PostMapping(value = "/monthly-balance", consumes = MediaType.APPLICATION_XML_VALUE)
	public List<NetBalance> getMonthlyNetBalance(@RequestBody Document document) {
		Assert.notNull(document, "must not be null");
		return monthlyNetBalanceService.getMonthlyNetBalance(document.getBkToCstmrStmt().getStmt());
	}

	/**
	 * A simple POST rest end point responsible for consuming an xml document and returning the number of days in debt.
	 *
	 * @param document consumed xml document
	 * @return no of days in debt
	 */
	@PostMapping(value = "/days-in-debt", consumes = MediaType.APPLICATION_XML_VALUE)
	public Integer getDaysInDebt(@RequestBody Document document) {
		Assert.notNull(document, "must not be null");
		return daysInDebtService.getDaysInDebt(document.getBkToCstmrStmt().getStmt());
	}
}
