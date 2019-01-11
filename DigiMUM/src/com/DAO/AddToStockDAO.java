package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Bean.Forex;
import com.Bean.GoogAPIBean;
import com.Connect.Connect;

public class AddToStockDAO {
	
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	
	public boolean addStock(GoogAPIBean st )
	{
		
		Connect c = new Connect();
		c.getDriver();
		int i=0;
		boolean flag=false;
		
		con=c.getConnection();
		
		String s="INSERT INTO MM_STOCKMARKET VALUES(STOCKID.nextval,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			ps=con.prepareStatement(s);
		
			ps.setString(1, st.getStockSymbol());
			ps.setString(2, st.getStockName());
			ps.setDouble(3, st.getCurrentPrice());
			ps.setDouble(4, st.getHigh52());
			ps.setDouble(5, st.getLow52());
			ps.setDouble(6, st.getChange());
			ps.setDouble(7, st.getLastChanged());
			ps.setDouble(8, st.getBuyingPrice());
			ps.setDouble(9, st.getSellingPrice());
			ps.setString(10, st.getMarketType());
		
			i = ps.executeUpdate();
			
			if(i!=0)
			{
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
	
	public boolean addForex(Forex st )
	{
		
		Connect c = new Connect();
		c.getDriver();
		int i=0;
		boolean flag=false;
		
		con=c.getConnection();
		
		String s="INSERT INTO MM_STOCKMARKET VALUES(STOCKID.nextval,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			ps=con.prepareStatement(s);
		
			ps.setString(1, st.getStockSymbol());
			ps.setString(2, st.getStockName());
			ps.setDouble(3, st.getCurrentPrice());
			ps.setDouble(4, st.getHigh52());
			ps.setDouble(5, st.getLow52());
			ps.setDouble(6, st.getChange());
			ps.setDouble(7, st.getLastChanged());
			ps.setDouble(8, st.getBuyingPrice());
			ps.setDouble(9, st.getSellingPrice());
			ps.setString(10, st.getMarketType());
		
			i = ps.executeUpdate();
			
			if(i!=0)
			{
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