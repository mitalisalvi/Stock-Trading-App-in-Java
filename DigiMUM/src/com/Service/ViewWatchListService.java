package com.Service;

import java.util.ArrayList;

import com.Bean.Customer;
import com.Bean.Watchlist;
import com.DAO.ViewWatchListDAO;

public class ViewWatchListService {
	
	public ArrayList<Watchlist> callviewWatchList(Customer cst,String markettype)
	{
		ViewWatchListDAO vwd = new ViewWatchListDAO();
		
		ArrayList<Watchlist> alwatch = new ArrayList<Watchlist> ();
		 
		
		alwatch = vwd.viewWatchList( cst,markettype);
		return alwatch;
		
	}

}
