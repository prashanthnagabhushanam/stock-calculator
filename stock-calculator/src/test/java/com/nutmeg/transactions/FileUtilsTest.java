package com.nutmeg.transactions;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.nutmeg.transactions.Transaction;
import static com.nutmeg.transactions.util.FileUtils.fileFromResources;
import static com.nutmeg.transactions.util.FileUtils.transactionFromFile;

public class FileUtilsTest {
	
	@Test
	public void with() throws IOException {
		String fileName = "all.csv";

		Map<String, List<Transaction>> transactions = transactionFromFile(
				fileFromResources(fileName), LocalDate.now());

		assertThat(transactions).isNotEmpty().containsOnlyKeys("NEAA0000",
				"NEAB0001");

	}
}
