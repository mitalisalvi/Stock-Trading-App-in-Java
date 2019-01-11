package com.DAO;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.Customer;

import com.Bean.ViewAlert;
import com.Connect.Connect;

public class ViewAlertDAO {
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;

	public ArrayList<ViewAlert> viewAlert(Customer cst)
	{
		Connect c = new Connect();
		c.getDriver();
		con = c.getConnection();
		String stockName;
		double currentPrice;
		double price;
		ArrayList<ViewAlert> alerts=new ArrayList<ViewAlert>(); 
		try
		{
			ps=con.prepareStatement("select MM_STOCKMARKET.stockname,MM_STOCKMARKET.currentprice,MM_ALERTS.price from MM_ALERTS inner join MM_STOCKMARKET on MM_STOCKMARKET.stockid=MM_ALERTS.stockid where MM_ALERTS.userid=? and MM_ALERTS.sign=1 ");
			ps.setInt(1, cst.getUserId());
			rs=ps.executeQuery();
			while(rs.next())
			{
				
				stockName=rs.getString(1);
				currentPrice=rs.getDouble(2);
				price=rs.getDouble(3);
				if(currentPrice>price)
				{
					ViewAlert a=new ViewAlert();
					a.setCurrentPrice(currentPrice);
					a.setPrice(price);
					a.setSign(1);
					a.setStockName(stockName);
					alerts.add(a);
				}
					
			}
			
			
			ps=con.prepareStatement("select MM_STOCKMARKET.stockname,MM_STOCKMARKET.currentprice,MM_ALERTS.price from MM_ALERTS inner join MM_STOCKMARKET on MM_STOCKMARKET.stockid=MM_ALERTS.stockid where MM_ALERTS.userid=? and MM_ALERTS.sign=-1");
			ps.setInt(1, cst.getUserId());
			rs=ps.executeQuery();
			while(rs.next())
			{
				stockName=rs.getString(1);
				currentPrice=rs.getDouble(2);
				price=rs.getDouble(3);
				if(currentPrice<price)
				{
					ViewAlert a=new ViewAlert();
					a.setCurrentPrice(currentPrice);
					a.setPrice(price);
					a.setSign(-1);
					a.setStockName(stockName);
					alerts.add(a);
				}
					
			}
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			c.closeResultSet(rs);
			c.closePreparedStatement(ps);
			c.closeConnection();
		}
		
		return alerts;
	}
}
