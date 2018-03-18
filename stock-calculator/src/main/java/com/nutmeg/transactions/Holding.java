package com.nutmeg.transactions;

public class Holding implements java.io.Serializable {
	
	private String asset;
	private double holding;

	public Holding(String asset, double holding) {
		this.asset = asset;
		this.holding = holding;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public double getHolding() {
		return holding;
	}

	public void setHoldings(double holding) {
		this.holding = holding;
	}

	public String toString() {
		return getAsset() + ":\t" + getHolding();
	}

	public void computeHolding(Transaction transaction) {
		Result result = transaction.getType().calculate(transaction);
		holding += result.getStock();
	}

	public void computeCash(Transaction transaction) {
		Result result = transaction.getType().calculate(transaction);
		holding += result.getCash();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Holding holding = (Holding) o;

		return asset != null ? asset.equals(holding.asset)
				: holding.asset == null;
	}

	@Override
	public int hashCode() {
		return asset != null ? asset.hashCode() : 0;
	}

	public static Holding of(Transaction transaction) {
		Result result = transaction.getType().calculate(transaction);
		return new Holding(transaction.getAsset(), result.getStock());
	}

	public static Holding CASH(Transaction transaction) {
		Result result = transaction.getType().calculate(transaction);
		return new Holding(transaction.getAsset(), result.getStock());
	}
}