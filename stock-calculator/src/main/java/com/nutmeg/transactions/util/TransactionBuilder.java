package com.nutmeg.transactions.util;

import java.time.LocalDate;

import com.nutmeg.transactions.Transaction;
import static java.time.format.DateTimeFormatter.BASIC_ISO_DATE;


public class TransactionBuilder {

	private String accountNumber;
	  private LocalDate date;
	  private TransactionType transactionType;
	  private double unit;
	  private double price;
	  private String asset;

	  public TransactionBuilder (String accountNumber, String date){
	    this.accountNumber = accountNumber;
	    this.date = LocalDate.parse(date, BASIC_ISO_DATE);
	  }

	  public TransactionBuilder withTransactionType(String type) {
	    this.transactionType = TransactionType.valueOf(type);
	    return this;
	  }

	  public TransactionBuilder hasUnit(String unit) {
	    this.unit = Double.valueOf (unit);
	    return this;
	  }

	  public TransactionBuilder hasAsset(String asset) {
	    this.asset = asset;
	    return this;
	  }

	  public TransactionBuilder hasPrice(String price) {
	    this.price = Double.valueOf(price);
	    return this;
	  }

	  public Transaction build() {
	    Transaction transaction = new Transaction(accountNumber, date);
	    transaction.setType(transactionType);
	    transaction.setPrice(price);
	    transaction.setUnit(unit);
	    transaction.setAsset(asset);
	    transaction.setAccountNumber(accountNumber);
	    transaction.setDate(date);
	    return transaction;
	  }
}
