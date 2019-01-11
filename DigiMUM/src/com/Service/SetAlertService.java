package com.Service;
import com.Bean.Alert;

import com.DAO.SetAlertDAO;

public class SetAlertService {

	public long getStockId(String symbol)
	{
		return (new SetAlertDAO().getStockID(symbol));
	}
	public boolean setAlert(Alert a)
	{
		
			return(new SetAlertDAO().setAlertDAO(a));
	}
	
}
