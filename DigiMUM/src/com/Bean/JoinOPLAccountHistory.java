package com.Bean;

public class JoinOPLAccountHistory {
	
	private String stockName;
	private double currentPrice;
	private double quantity;
	private double profitLoss;
	private double averageBuying;
	private double stop;
	
	public String getStockName() {
		return stockName;
	}
	
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	public double getCurrentPrice() {
		return currentPrice;
	}
	
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}
	
	public double getQuantity() {
		return quantity;
	}
	
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public double getProfitLoss() {
		return profitLoss;
	}
	
	public void setProfitLoss(double profitLoss) {
		this.profitLoss = profitLoss;
	}
	
	public double getAverageBuying() {
		return averageBuying;
	}
	
	public void setAverageBuying(double averageBuying) {
		this.averageBuying = averageBuying;
	}
	
	public double getStop() {
		return stop;
	}
	
	public void setStop(double stop) {
		this.stop = stop;
	}
}