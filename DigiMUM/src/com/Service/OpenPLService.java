package com.Service;

import com.Bean.Customer;
import com.DAO.OpenPLDAO;

public class OpenPLService {
	
	public double callshowOpenPL(Customer cst)
	{
		OpenPLDAO opd = new OpenPLDAO();
		Double totalpl = opd.showOpenPL(cst);
		return totalpl;
	}

	public double callshowAccountEvaluation(Customer cst, double totalop)
	{
		OpenPLDAO opd = new OpenPLDAO();
		Double accval = opd.showAccountValuation(cst, totalop);
		return accval;
	}
}
