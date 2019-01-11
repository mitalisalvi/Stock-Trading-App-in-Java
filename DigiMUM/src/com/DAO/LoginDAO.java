package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.Customer;
import com.Bean.Login;
import com.Connect.Connect;

public class LoginDAO {
	PreparedStatement ps = null;
	Connection c = null;
	ResultSet rs = null;
	Customer cs=null;

	public Customer getCustomer(Login log) {
		
		Connect con = new Connect();
		
		int loggedin = 0;

		
			con.getDriver();
			c = con.getConnection();
			try{
			ps = c.prepareStatement("select userId from mm_login where userName=? AND password=?");
			ps.setString(1, log.getUserName());
			ps.setString(2, log.getPassword());

			rs = ps.executeQuery();
			while (rs.next()) {
				loggedin = rs.getInt(1);
			}

			ps = c.prepareStatement("select * from mm_customerdetails where userid=?");
			ps.setInt(1, loggedin);
			rs = ps.executeQuery();

			while (rs.next()) {
				cs = new Customer();
				cs.setUserId(rs.getInt(1));
				cs.setFirstName(rs.getString(2));
				cs.setLastName(rs.getString(3));
				cs.setDob(rs.getString(4));
				cs.setCountry(rs.getString(5));
				cs.setPhoneNumber(rs.getLong(6));
				cs.setEmail(rs.getString(9));
				cs.setSecretAnswer(rs.getString(7));
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		finally{
			con.closeResultSet(rs);
			con.closePreparedStatement(ps);
			con.closeConnection();
		}
		
		return cs;
	}
	
	public boolean checkUser(Login log)
	{
	
		Connect con = new Connect();
	
		boolean flag=false;

		
			con.getDriver();
			c = con.getConnection();
			try{
			
			ps = c.prepareStatement("select userName,password from mm_login where userName=?");
			ps.setString(1, log.getUserName());
			

			rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getString(2).equals(log.getPassword()))
					flag=true;
			}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		
		finally{
			con.closeResultSet(rs);
			con.closePreparedStatement(ps);
			con.closeConnection();
		}
		return flag;
	}
	
	

}
