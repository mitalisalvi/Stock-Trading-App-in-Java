package com.Service;

import com.Bean.Customer;
import com.Bean.TradeAccount;
import com.DAO.ViewUpdateDAO;


//SERVICE FOR VIEW UPDATE DAO 

public class ViewUpdateTransService {
	
	ViewUpdateDAO vudao=new ViewUpdateDAO();
	
	public TradeAccount viewProfile (Customer cst)
	{
		TradeAccount tradeacc=vudao.viewProfile(cst);
		return tradeacc;
	}
	
	
	public boolean updateCustomer (Customer cd)
	{
		boolean flag=vudao.updateCustomer(cd);
		return flag;
	}
	
	public Customer updateProfile(Customer cst) 
	{
		Customer cst1=vudao.updateProfile(cst);
		return cst1;
	}
	
	
	public boolean checkEmail(Customer cst) 
	{
		boolean flag=vudao.checkEmail(cst);
		return flag;
	}
	
	public boolean checkPhoneNumber(Customer cst) 
	{
		boolean flag=vudao.checkPhoneNumber(cst);
		return flag;
		
	}

}
