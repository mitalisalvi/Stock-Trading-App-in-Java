package com.Service;

import com.Bean.Customer;
import com.DAO.AddToWatchlistDAO;
import com.DAO.ViewWatchListDAO;

public class WatchlistService
{
	AddToWatchlistDAO atwdao = new AddToWatchlistDAO();
	ViewWatchListDAO viwdao = new ViewWatchListDAO();
	
	public boolean addToWatchlist(int id,Customer cst)
	{
		if(atwdao.checkWatchlist(id, cst))
			return atwdao.insertStock(id, cst);
		else return false;
	}
	
	public boolean deleteFromWatchlist(String symbol,Customer cst)
	{
	    return viwdao.deleteFromWatchlist(symbol,cst);
	}
}