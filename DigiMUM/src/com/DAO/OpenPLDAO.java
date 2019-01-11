package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Bean.Customer;
import com.Connect.Connect;

public class OpenPLDAO {
	PreparedStatement ps = null;
	Connection c = null;
	ResultSet rs = null;
	Customer cs=null;
	
	ArrayList<Double> oplal= new  ArrayList<Double>();
	double ff= 0;
	double cashbalance= 0;
	double accval=0;
	
	public double showOpenPL(Customer cst){
		
		Connect con = new Connect();	
		con.getDriver();
		c = con.getConnection();
		
	try {
		ps = c.prepareStatement("select profitloss from mm_trades where userid=?");
		ps.setInt(1, cst.getUserId());
		rs= ps.executeQuery();
		
		while(rs.next())
		{
			oplal.add(rs.getDouble(1));
		}
		
		for(Double dd:oplal)
			ff= ff+dd;
		//(No of Stackes * Selling Price ) -- (No. of Stackes * Buying Price)
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}finally{
		con.closeResultSet(rs);
		con.closePreparedStatement(ps);
		con.closeConnection();
	}
	
	return ff;
	
	}
	
	public double showAccountValuation(Customer cst, double dd)
	{
		Connect con = new Connect();	
		con.getDriver();
		c = con.getConnection();
		
		try {
			ps = c.prepareStatement("select cashbalance from mm_tradeaccount where userid=?");
			ps.setInt(1, cst.getUserId());
			rs= ps.executeQuery();
			while(rs.next())
			{
				cashbalance = rs.getDouble(1);
			}
			
			accval= dd+cashbalance;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally{
			con.closeResultSet(rs);
			con.closePreparedStatement(ps);
			con.closeConnection();
		}
		
		
		return accval;
	}

}
