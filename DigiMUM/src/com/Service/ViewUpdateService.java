package com.Service;

import com.Bean.*;
import com.DAO.ViewUpdateDAO;

public class ViewUpdateService
{
	public String checkUnique(Customer cst)
	{
		ViewUpdateDAO vudao = new ViewUpdateDAO();
		if(vudao.checkEmail(cst))
			if(vudao.checkPhoneNumber(cst))
				return "correct";
			else return "phoneNumber";
		else return "email";
	}
	 
	public boolean updateStatus(Customer cst)
	{
		ViewUpdateDAO vudao = new ViewUpdateDAO();
		return vudao.updateCustomer(cst);
	}
	
	public Customer updateConfirm(Customer cst)
	{
		ViewUpdateDAO vudao = new ViewUpdateDAO();
		return vudao.updateProfile(cst);
	}
}
