package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.Bank;
import com.Bean.Customer;
import com.Bean.TradeAccount;
import com.Connect.Connect;

public class FundTransferDAO {
	
	PreparedStatement ps = null;
	Connection c = null;
	ResultSet rs = null;
	Bank bank = null;
	double oldcashbalance=0;
	double newcashbalance=0;
	
	public Bank findbank(String bankName)
	{
            Connect con = new Connect();	
			con.getDriver();
			c = con.getConnection();
	
			try {
				ps = c.prepareStatement("select bankid from mm_bank where bankname=?");
				ps.setString(1,bankName);
				
				rs = ps.executeQuery();
				while(rs.next())
				{
					bank = new Bank();
					bank.setBankId(rs.getInt(1));
				}
				
			} 
			
			catch (Exception e)
			{
				
				e.printStackTrace();
			}
			
			finally
			{
				con.closeResultSet(rs);
				con.closePreparedStatement(ps);
				con.closeConnection();
			}
			
			return bank;
	}
			
			public boolean fundtransfer(TradeAccount tra, Double dd)
			{
				Connect con = new Connect();	
				con.getDriver();
				c = con.getConnection();
				
				int inserted=0;
				boolean flag = false;
				try {
					
					ps = c.prepareStatement("select cashbalance from MM_TRADEACCOUNT where userid=?");
					ps.setInt(1, tra.getUserId());
					rs= ps.executeQuery();
					while(rs.next())
						oldcashbalance= rs.getDouble(1);
					
					newcashbalance = oldcashbalance+ dd;
					
					ps = c.prepareStatement("update MM_TRADEACCOUNT set cashbalance=? where userid=?");
					
					ps.setDouble(1, newcashbalance);
					ps.setInt(2, tra.getUserId());
					
					inserted = ps.executeUpdate();
					if (inserted!=0)
							flag= true;
					
						
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				finally
				{
					con.closeResultSet(rs);
					con.closePreparedStatement(ps);
					con.closeConnection();
				}
				
				return flag;
			}
}