package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.*;

import com.Bean.Bank;
import com.Bean.Customer;
import com.Connect.Connect;

public class ViewWatchListDAO {
	
	PreparedStatement ps = null;
	Connection c = null;
	ResultSet rs = null;
	Bank bank = null;
	ArrayList<Watchlist> alwatch = new ArrayList<Watchlist> ();
	
	public ArrayList<Watchlist> viewWatchList(Customer cst,String markettype){
		
		Connect con = new Connect();	
		con.getDriver();
		c = con.getConnection();
		
		try {
			ps = c.prepareStatement("select * from mm_watchlist where markettype=? and userid=?");
			
			ps.setString(1, markettype);
			
			ps.setInt(2, cst.getUserId());
			
			rs = ps.executeQuery();
			System.out.println("hello");
			while(rs.next())
			{
				Watchlist wl = new Watchlist();
				
				wl.setUserId(rs.getInt("userid"));
				wl.setStockSymbol(rs.getString("symbol"));
				wl.setStockName(rs.getString("stockname"));
				wl.setStockId(rs.getInt("stockid"));
				wl.setSellingPrice(rs.getDouble("sellingprice"));
				wl.setBuyingPrice(rs.getDouble("buyingprice"));
				wl.setChange(rs.getDouble("change"));
				wl.setCurrentPrice(rs.getDouble("currentprice"));
				wl.setHigh52(rs.getDouble("high52"));
				wl.setLastChanged(rs.getDouble("lastclosed"));
				wl.setLow52(rs.getDouble("low52"));
				wl.setMarketType(rs.getString("markettype"));
				alwatch.add(wl);
			} 
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			con.closeResultSet(rs);
			con.closePreparedStatement(ps);
			con.closeConnection();
		}
		
		return alwatch;
	}

	
	public boolean deleteFromWatchlist(String symbol, Customer cst)
	{
		  Connect con = new Connect();
		  con.getDriver();
		  c = con.getConnection();
		  int i=0;
		
		try
	    {
	          ps=c.prepareStatement("delete from mm_watchlist where symbol=? and userid=?");
		      ps.setString(1,symbol);
		      ps.setInt(2,cst.getUserId());
	          i = ps.executeUpdate();
	          
	          
	          
	    } 
		
		catch (SQLException e)
	    {
			e.printStackTrace();
		}
	  
		finally
		{
			con.closePreparedStatement(ps);
			con.closeConnection();
		}
		
		if(i!=0)
			return true;
		else return false;
    }
}
