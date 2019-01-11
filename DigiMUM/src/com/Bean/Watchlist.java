package com.Bean;

public class Watchlist {
	
	private long stockId;
	private String stockSymbol;
	private String stockName;
	private double currentPrice;
	private double high52;
	private double low52;
	private double change;
	private double lastChanged;
	private double buyingPrice;
	private double sellingPrice;
	private String marketType;
	private int userId;
	
	
	public long getStockId() {
		return stockId;
	}
	public void setStockId(long stockId) {
		this.stockId = stockId;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
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
	public double getHigh52() {
		return high52;
	}
	public void setHigh52(double high52) {
		this.high52 = high52;
	}
	public double getLow52() {
		return low52;
	}
	public void setLow52(double low52) {
		this.low52 = low52;
	}
	public double getChange() {
		return change;
	}
	public void setChange(double change) {
		this.change = change;
	}
	public double getLastChanged() {
		return lastChanged;
	}
	public void setLastChanged(double lastChanged) {
		this.lastChanged = lastChanged;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public String getMarketType() {
		return marketType;
	}
	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
	
	

}
