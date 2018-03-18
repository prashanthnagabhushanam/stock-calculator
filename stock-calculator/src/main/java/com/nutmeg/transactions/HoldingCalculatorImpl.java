package com.nutmeg.transactions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import static com.nutmeg.transactions.util.FileUtils.transactionFromFile;
import static java.util.stream.Collectors.groupingBy;

public class HoldingCalculatorImpl implements HoldingCalculator {

	@Override
	public Map<String, List<Holding>> calculateHoldings(File transactionFile,
			LocalDate date) {
		try {
			Map<String, List<Transaction>> transactions = transactionFromFile(
					transactionFile, date);

	return	transactions
					.entrySet()
					.stream()
					.flatMap(b -> b.getValue().stream())
					.collect(
							groupingBy(
									Transaction::getAccountNumber,
									Collector
											.of(ArrayList::new, // Supplier

													(list, transaction) -> { // Accumulator
														Holding currentHolding = Holding
																.of(transaction);
														if (list.contains(currentHolding)) {
															Holding oldHolding = list.get(list
																	.indexOf(currentHolding));
															oldHolding
																	.computeHolding(transaction);

															Holding cashHolding = Holding
																	.CASH(transaction);
															if (cashHolding != null) {
																cashHolding
																		.computeCash(transaction);
															}

														} else {
															list.add(currentHolding);
														}
													},

													(responseList, holdingList) -> { // Combiner
														holdingList.addAll(responseList);
														return holdingList;
													})));
			
			

		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}

	}

}
