package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.Customer;
import com.Bean.JoinOPLAccountHistory;

import com.Connect.Connect;

public class OpenPositionAccountHistoryDAO {
	PreparedStatement ps = null;
	Connection c = null;
	ResultSet rs = null;
	Customer cs=null;
	ArrayList<JoinOPLAccountHistory> placchist = new ArrayList<JoinOPLAccountHistory>();
	
	
	public ArrayList<JoinOPLAccountHistory> gettradehistory(Customer cst)
	{
		Connect con = new Connect();	
		con.getDriver();
		c = con.getConnection();
		
		try 
		{
			ps = c.prepareStatement("SELECT MM_STOCKMARKET.stockname,MM_STOCKMARKET.currentprice,MM_TRADES.QUANTITY,MM_TRADES.PROFITLOSS,MM_TRADES.AVERAGEBUYING, mm_trades.stop FROM MM_TRADESINNER JOIN MM_STOCKMARKET ON MM_TRAdes.STOCKID= MM_STOCKMARKET.STOCKIDwhere MM_TRADES.userid=? ORDER BY MM_TRADES.STOCKID");
			ps.setInt(1, cst.getUserId());
			rs= ps.executeQuery();
			
			while(rs.next())
			{   
				JoinOPLAccountHistory jj = new  JoinOPLAccountHistory();
			
				jj.setStockName(rs.getString(1));
				jj.setCurrentPrice(rs.getDouble(2));
				jj.setQuantity(rs.getDouble(3));
				jj.setProfitLoss(rs.getDouble(4));
				jj.setAverageBuying(rs.getDouble(5));
				jj.setStop(rs.getDouble(6));
				
				placchist.add(jj);
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
		return placchist;
	}
}