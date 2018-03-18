package com.nutmeg.transactions;

public class Result {
	private double cash;
	private double stock;

	public Result(double cash, double stock) {
		this.cash = cash;
		this.stock = stock;
	}

	public double getCash() {
		return cash;
	}

	public double getStock() {
		return stock;
	}
}
