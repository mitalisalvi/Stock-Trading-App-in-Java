package com.Service;

import com.Bean.Customer;
import com.DAO.ChangePasswordDAO;

public class ChangePasswordService 
{
	public boolean replacePassword(Customer cst, String oldPassword,String newPassword)
	{
		ChangePasswordDAO cpdao = new ChangePasswordDAO();
		boolean f = cpdao.checkPassword(cst, oldPassword);
		System.out.println(f+"service");
		if(f)
		{
			boolean t = cpdao.changePassword(cst, newPassword);
			return t;
		}
		else return false;
 	}
}
