package com.Service;

import com.Bean.*;
import com.DAO.AccountStatementDAO;

public class AccountStatementService 
{
	public String fDate;
	public String tDate;
	
	public AccountStatementService(String fDate, String tDate) {
		this.fDate = fDate;
		this.tDate = tDate;
	}

	public AccountStatement  getAccountStatement(Customer cst)
	{
		
	AccountStatementDAO astdao = new AccountStatementDAO();
		return(astdao.getAccountStatement(cst,fDate,tDate));
	}
}
