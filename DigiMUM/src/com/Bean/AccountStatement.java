package com.Bean;

import java.util.ArrayList;

public class AccountStatement 
{
	private int userId ;
	private double currentBalance;
	private ArrayList<Transaction> transactions =  new ArrayList<>();
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	
	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}
	
	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}
}
