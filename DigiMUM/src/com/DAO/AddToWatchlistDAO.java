package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.SQLException;

import com.Bean.Customer;
import com.Bean.Stock;
//import com.Bean.Stock;
import com.Connect.Connect;

public class AddToWatchlistDAO {
	
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;

	
	
	public boolean checkWatchlist(int id, Customer cst)
	{
		  boolean flag = true;
		  Connect c = new Connect();
		  c.getDriver();
		  con = c.getConnection();
		
		try
	    {
	          ps=con.prepareStatement("select userid from mm_watchlist where stockid = ?");
		      ps.setInt(1,id);
	          rs = ps.executeQuery();
	          while(rs.next())
	          {
	        	  if (rs.getInt(1) == cst.getUserId())
	        	  {
	        		  flag = false;
	        		  break;
	        	  }
	          }
	    } 
		
		catch (SQLException e)
	    {
			e.printStackTrace();
		}
	  
		finally
		{
			c.closePreparedStatement(ps);
			c.closeConnection();
		}
		
		return flag;
    }

	
	
	
	public boolean insertStock(int id, Customer cst)
	{
		
		Connect c = new Connect();
		c.getDriver();
		int i=0,j=0;
		boolean flag=false;
	    Stock ss = new Stock();
		
		con=c.getConnection();
		
		String select="SELECT * FROM MM_STOCKMARKET where MM_STOCKMARKET.STOCKID=?";
		String insert="INSERT INTO MM_WATCHLIST VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try
		{	
			ps = con.prepareStatement(select);
			ps.setInt(1,id);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				ss.setStockId(rs.getLong("stockid"));
				ss.setStockSymbol(rs.getString("symbol"));
				ss.setStockName(rs.getString("stockname"));
				ss.setCurrentPrice(rs.getDouble("currentprice"));
				ss.setHigh52(rs.getDouble("high52"));
				ss.setLow52(rs.getDouble("low52"));
				ss.setChange(rs.getDouble("change"));
				ss.setLastChanged(rs.getDouble("lastclosed"));
				ss.setBuyingPrice(rs.getDouble("buyingprice"));
				ss.setSellingPrice(rs.getDouble("sellingprice"));
				ss.setMarketType(rs.getString("markettype"));
			}
			
			if(i!=0)
			{
				System.out.println("stock bullshit set");
				flag=true;
			}			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
		try
		{

			ps=con.prepareStatement(insert);
			
			
			ps.setLong(1,ss.getStockId());
			ps.setString(2,ss.getStockSymbol());
			ps.setString(3,ss.getStockName());
			ps.setDouble(4,ss.getCurrentPrice());
			ps.setDouble(5,ss.getHigh52());
			ps.setDouble(6,ss.getLow52());
			ps.setDouble(7,ss.getChange());
			ps.setDouble(8,ss.getLastChanged());
			ps.setDouble(9,ss.getBuyingPrice());
			ps.setDouble(10,ss.getSellingPrice());
			ps.setString(11,ss.getMarketType());
			ps.setInt(12, cst.getUserId());
			
			j=ps.executeUpdate();
			
			if(j!=0)
			{
				System.out.println("userid set");
				flag=true;
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			c.closeResultSet(rs);
			c.closePreparedStatement(ps);
			c.closeConnection();
		}
		return flag;
		}
}