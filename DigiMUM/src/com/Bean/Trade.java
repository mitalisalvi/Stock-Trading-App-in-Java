package com.Bean;

public class Trade {
	
	private double averageBuying;
	private double averageSelling;
	private double stop;
	private int userId;
	private long stockId;
	private int quantity;
	
	public double getAverageBuying() {
		return averageBuying;
	}
	public void setAverageBuying(double averageBuying) {
		this.averageBuying = averageBuying;
	}
	public double getAverageSelling() {
		return averageSelling;
	}
	public void setAverageSelling(double averageSelling) {
		this.averageSelling = averageSelling;
	}
	public double getStop() {
		return stop;
	}
	public void setStop(double stop) {
		this.stop = stop;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
