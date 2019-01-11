package com.Service;

import com.Bean.Bank;
import com.Bean.TradeAccount;
import com.DAO.FundTransferDAO;

public class FundTransferService {

	public Bank callBank(String bankName)
	{
		FundTransferDAO ftd = new FundTransferDAO();
		Bank bb = ftd.findbank(bankName);
		return bb;
	}
	
	public boolean callFundTransfer(TradeAccount tra,double dd)
	{
		FundTransferDAO ftd = new FundTransferDAO();
		boolean flag = ftd.fundtransfer(tra,dd);
		return flag;
	}
}
