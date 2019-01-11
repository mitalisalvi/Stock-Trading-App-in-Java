package com.Service;

import java.util.ArrayList;

import com.Bean.Customer;
import com.Bean.Stock;
import com.Bean.TradeAccount;
import com.Bean.Transaction;
import com.DAO.TransactionDAO;

public class TransactionService {
	
	TransactionDAO tdao=new TransactionDAO();
	
	public Stock getStock(int id)
	{
		Stock ss=tdao.getStock(id);
		return ss;
				
	}
	
	public  boolean isValidTransaction(TradeAccount trac, Stock st, int quantity, String buySell)
	{
		if((st.getBuyingPrice()*quantity)<=trac.getCashBalance())
			{
				return true;
			}
			else
				return false;
	}
	
	
	public boolean doTransaction(Customer cst, Stock st, int quantity, String buySell)
	{
		boolean flag=tdao.doTransaction(cst, st, quantity, buySell);
		return flag;
		
	}
	
	public ArrayList<Transaction> getTransaction (Customer cst)
	{
		ArrayList<Transaction> transactionList=tdao.getTransaction(cst);
		return transactionList;
	}
	
	
	
	
}
