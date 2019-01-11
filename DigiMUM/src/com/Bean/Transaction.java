package com.Bean;

import java.sql.Timestamp;
import java.util.Date;

public class Transaction {
	
	private int transactionId;
	private int userId;
	private long stockId;
	private Timestamp timestampdate;
	private int quantity;
	private String buySell;
	private double tradePrice;
	
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
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
	
	public Timestamp getTimestampdate() {
		return timestampdate;
	}
	public void setTimestampdate(Timestamp timestampdate) {
		this.timestampdate = timestampdate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getBuySell() {
		return buySell;
	}
	public void setBuySell(String buySell) {
		this.buySell = buySell;
	}
	public double getTradePrice() {
		return tradePrice;
	}
	public void setTradePrice(double tradePrice) {
		this.tradePrice = tradePrice;
	}
}