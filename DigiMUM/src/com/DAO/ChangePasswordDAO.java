package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.Customer;
import com.Connect.Connect;

public class ChangePasswordDAO 
{
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;
	
	public boolean checkPassword(Customer cst, String oldPassword)
	{
		  boolean flag  = false;
		  Connect c = new Connect();
		  c.getDriver();
		  con = c.getConnection();
		
		try
	      {
	          ps=con.prepareStatement("select password from mm_login where userId = ?");
		      ps.setInt(1,cst.getUserId());
	          rs = ps.executeQuery();
	          while(rs.next())
	          {
	        	 if (rs.getString(1).equals(oldPassword))
	        	 flag = true;
	          }
	          
	      } 
		catch (SQLException e)
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
	
	public boolean changePassword(Customer cst,String newPassword)
	{
		Connect c = new Connect();
		c.getDriver();
		con = c.getConnection();
		int k=0;
		try 
		{
			ps = con.prepareStatement("update mm_login set password=? where userId=?");
			ps.setString(1, newPassword);
			ps.setInt(2, cst.getUserId());
			k= ps.executeUpdate();
		} 
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		} 
		
		finally 
		{
			c.closeResultSet(rs);
			c.closePreparedStatement(ps);
			c.closeConnection();

		}
		if (k!=0)
			return true;
		else return false;
		
	}
}