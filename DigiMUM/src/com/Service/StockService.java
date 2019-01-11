package com.Service;

import java.util.ArrayList;

import com.Bean.Customer;
import com.Bean.Forex;
import com.Bean.GoogAPIBean;
import com.Bean.Stock;
import com.DAO.AddToWatchlistDAO;
import com.DAO.UpdateStockDAO;
import com.DAO.ViewMarketDAO;

public class StockService {
	
	public /*static*/ int count=1;

	UpdateStockDAO utsdao = new UpdateStockDAO();
	AddToWatchlistDAO atwd=new AddToWatchlistDAO();
	ViewMarketDAO vmd=new ViewMarketDAO();

	public boolean populateStock(ArrayList<GoogAPIBean> stockList) 
	{
		System.out.println("inside service layer");


		for (int i = 0; i < stockList.size(); i++) 
		{
			if (utsdao.updateStock(stockList.get(i),count)) 
			{
					count++;
			} 
			
			else 
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean populateForex(ArrayList<Forex> forexList) 
	{

		for (int i = 0; i < forexList.size(); i++) 
		{
			if (utsdao.updateForex(forexList.get(i),count)) 
			{	
				count++;

			} 
			
			else 
			{
				return false;
			}
		}
		return true;
	}
	
	public boolean insertStock(int id, Customer cst)
	{
		
		boolean flag=atwd.insertStock(id, cst);
		return flag;
		
	}
	
	public ArrayList<Stock> viewMarket(String market)
	{
		ArrayList<Stock> res=vmd.viewMarket(market);
		return res;
	}
}
