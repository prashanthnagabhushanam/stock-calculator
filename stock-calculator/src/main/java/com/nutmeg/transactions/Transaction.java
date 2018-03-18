package com.nutmeg.transactions;

import java.time.LocalDate;

import com.nutmeg.transactions.util.TransactionType;

public class Transaction {

	private String accountNumber;
	  private LocalDate date;
	  private TransactionType type;
	  private double unit;
	  private String asset;
	  private double price;

	  public Transaction(String accountNumber, LocalDate date){
	    this.accountNumber = accountNumber;
	    this.date = date;
	  }

	  public String getAccountNumber() {
	    return accountNumber;
	  }

	  public void setAccountNumber(String accountNumber) {
	    this.accountNumber = accountNumber;
	  }

	  public LocalDate getDate() {
	    return date;
	  }

	  public void setDate(LocalDate date) {
	    this.date = date;
	  }

	  public TransactionType getType() {
	    return type;
	  }

	  public void setType(TransactionType type) {
	    this.type = type;
	  }

	  public double getUnit() {
	    return unit;
	  }

	  public void setUnit(double unit) {
	    this.unit = unit;
	  }

	  public String getAsset() {
	    return asset;
	  }

	  public void setAsset(String asset) {
	    this.asset = asset;
	  }

	  public double getPrice() {
	    return price;
	  }

	  public void setPrice(double price) {
	    this.price = price;
	  }

	  @Override
	  public String toString() {
	    return "Transaction{" +
	        "accountNumber='" + accountNumber + '\'' +
	        ", date=" + date +
	        ", type=" + type +
	        ", unit=" + unit +
	        ", asset='" + asset + '\'' +
	        ", price=" + price +
	        '}';
	  }

	  @Override
	  public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    Transaction that = (Transaction) o;

	    if (Double.compare(that.unit, unit) != 0) return false;
	    if (Double.compare(that.price, price) != 0) return false;
	    if (accountNumber != null ? !accountNumber.equals(that.accountNumber) : that.accountNumber != null) return false;
	    if (date != null ? !date.equals(that.date) : that.date != null) return false;
	    if (type != that.type) return false;
	    return asset != null ? asset.equals(that.asset) : that.asset == null;
	  }

	  @Override
	  public int hashCode() {
	    int result;
	    long temp;
	    result = accountNumber != null ? accountNumber.hashCode() : 0;
	    result = 31 * result + (date != null ? date.hashCode() : 0);
	    result = 31 * result + (type != null ? type.hashCode() : 0);
	    temp = Double.doubleToLongBits(unit);
	    result = 31 * result + (int) (temp ^ (temp >>> 32));
	    result = 31 * result + (asset != null ? asset.hashCode() : 0);
	    temp = Double.doubleToLongBits(price);
	    result = 31 * result + (int) (temp ^ (temp >>> 32));
	    return result;
	  }
}
