package com.Bean;

public class GoogAPIBean {
	
	private String stockName;
	private String stockSymbol;
	private double currentPrice;
	private double change;
	private double lastChanged;
	private double buyingPrice;
	private double sellingPrice;
	private double high52;
	private double low52;
	private String marketType;
	
	public String getMarketType() {
		return marketType;
	}
	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public double getCurrentPrice() {
		return currentPrice;
	}
	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
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
	
	

	
	/*public String toString ()
	{
		return this.getName()+" "+this.getHigh()+" "+this.getLive()+" "+this.getHigh52();
	}*/
	
	
	

}
