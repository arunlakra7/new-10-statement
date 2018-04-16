package com.new10.helper;

import com.google.common.collect.FluentIterable;
import com.new10.xmlpojo.NtryItem;

import java.util.List;

import org.springframework.util.Assert;

/**
 * Facilitates addition of a list of transactions.
 */
public final class AddTransactions {

	static final Double ZERO = Double.valueOf("0");

	private AddTransactions() {
		// no pubic constructor
	}

	/**
	 * Returns sum of a list of debit or credit transactions.
	 *
	 * @param cdtDbtInd    Credit, Debit
	 * @param transactions a list of transactions to be added
	 * @return zero if there were no debit or credit transactions to sum
	 */
	public static Double add(final String cdtDbtInd, final List<NtryItem> transactions) {
		Assert.notNull(cdtDbtInd, "must not be null");
		Assert.notNull(transactions, "must not be null");

		final List<Double> transactionsByCdDbtInd = FluentIterable.from(transactions)
			.filter((final NtryItem item) -> {
				return item.getCdtDbtInd().equals(cdtDbtInd);        // filter the transactions based on requested cdtDbtInd
			})
			.transform((final NtryItem item) -> item.getAmt().getValueAsDouble())  // get value as Double of the filtered transactions
			.toList();
		if (transactionsByCdDbtInd.isEmpty()) {
			return ZERO;
		}

		return transactionsByCdDbtInd
			.stream()
			.mapToDouble(Double::doubleValue)
			.sum();
	}
}
