package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.Customer;
import com.Connect.Connect;

public class CashBalanceDAO {
	
	PreparedStatement ps = null;
	Connection c = null;
	ResultSet rs = null;
	Customer cs=null;
	
	public double getCashBalance(Customer cst)
	{
		Connect con = new Connect();	
		con.getDriver();
		c = con.getConnection();
		double cashbalance = 0 ;
		
		try {
			ps = c.prepareStatement("select cashbalance from mm_tradeaccount where userid=?");
			ps.setInt(1,cst.getUserId() );
			
			rs= ps.executeQuery();
			
			while(rs.next())
				cashbalance = rs.getDouble(1);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			con.closeResultSet(rs);
			con.closePreparedStatement(ps);
			con.closeConnection();
		}
		
		return cashbalance;

	}

}
