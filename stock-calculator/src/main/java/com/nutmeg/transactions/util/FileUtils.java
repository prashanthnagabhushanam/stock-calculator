package com.nutmeg.transactions.util;

import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.nutmeg.transactions.Transaction;

public class FileUtils {

	private static final DateTimeFormatter formatter = DateTimeFormatter
			.ofPattern("YYYYMMDD");

	public static Map<String, List<Transaction>> transactionFromFile(
			File transactionFile, LocalDate date) throws IOException {
		try (Stream<String> lines = Files.lines(Paths.get((transactionFile
				.getAbsolutePath())))) {
			return lines
					.map(line -> line.split(","))
					.filter(data -> date.equals(
							LocalDate.parse(data[1], BASIC_ISO_DATE)))
					.collect(
							groupingBy(
									array -> array[0].trim(),
									mapping(array -> new TransactionBuilder(
											array[0].trim(), array[1].trim())
											.withTransactionType(
													array[2].trim())
											.hasUnit(array[3].trim())
											.hasPrice(array[4].trim())
											.hasAsset(array[5].trim()).build(),
											toList())));

		} catch (IOException e) {
			throw new IOException();
		}
	}

	public static File fileFromResources(String fileName) {
		ClassLoader classLoader = FileUtils.class.getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		return file;
	}
}
