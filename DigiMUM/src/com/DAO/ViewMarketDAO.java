package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.Bean.GoogAPIBean;
import com.Bean.Stock;
import com.Connect.Connect;

public class ViewMarketDAO {
	
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	ArrayList<Stock> viewList=new ArrayList<>();
	
	
	public ArrayList<Stock> viewMarket(String market)
	{
		
		Connect c = new Connect();
		c.getDriver();
		con=c.getConnection();
		
		String s="SELECT * FROM MM_STOCKMARKET WHERE MARKETTYPE=?";
		try
		{
			ps=con.prepareStatement(s);
			ps.setString(1,market);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Stock ss=new Stock();
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
				
				viewList.add(ss);

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
		return viewList;
	}
	
	
	

}
