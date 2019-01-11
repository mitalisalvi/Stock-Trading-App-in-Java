package com.Service;

import com.Bean.Customer;
import com.DAO.CashBalanceDAO;

public class CashBalanceService {
	
	public double callgetCashBalance(Customer cst)
	{
		CashBalanceDAO cbd= new CashBalanceDAO();
		double cashbalance= cbd.getCashBalance(cst);
		return cashbalance;
	}

}
