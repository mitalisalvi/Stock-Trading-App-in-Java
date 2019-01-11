package com.Service;

import java.util.ArrayList;

import com.Bean.Customer;
import com.Bean.JoinOPLAccountHistory;
import com.DAO.OpenPositionAccountHistoryDAO;

public class OpenPositionAccountHistoryService {
	
	public ArrayList<JoinOPLAccountHistory> callgettradehistory(Customer cst)
	{
		OpenPositionAccountHistoryDAO opah = new OpenPositionAccountHistoryDAO();
		ArrayList<JoinOPLAccountHistory> oacal = new ArrayList<JoinOPLAccountHistory>();
		oacal= opah.gettradehistory(cst);
		return oacal;
	}

}
