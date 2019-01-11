package com.DAO;

import java.sql.*;
import com.Connect.Connect;

public class ForgotPasswordDAO {

	PreparedStatement ps = null;
	Connection c = null;
	ResultSet rs = null;

	public boolean checkUserName(String userName) {
		Connect con = new Connect();
		con.getDriver();
		c = con.getConnection();
		boolean flag = false;
		try {
			PreparedStatement ps = c.prepareStatement("Select userName from mm_login where userName=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(userName))
				
				flag = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.closeResultSet(rs);
			con.closePreparedStatement(ps);
			con.closeConnection();

		}
		return flag;

	}
	
	public boolean checkSecretAnswer(String userName,String secretAnswer)
	{
		Connect con = new Connect();
		con.getDriver();
		c = con.getConnection();
		boolean flag = false;
		int userId=0;
		try {
			PreparedStatement ps = c.prepareStatement("select userId from mm_login where userName=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			userId=rs.getInt(1);
			}
			
			ps = c.prepareStatement("select secretAnswer from mm_customerdetails where userId=?");
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				if (rs.getString(1).equals(secretAnswer))
					flag = true;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.closeResultSet(rs);
			con.closePreparedStatement(ps);
			con.closeConnection();

		}
		return flag;
	}
	
	public boolean changePassword(String userName,String newPassword)
	{
		Connect con = new Connect();
		con.getDriver();
		c = con.getConnection();
		boolean flag = false;
		int userId=0;
			try {
			PreparedStatement ps = c.prepareStatement("select userId from mm_login where userName=?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
			userId=rs.getInt(1);
			}
			
			ps = c.prepareStatement("update mm_login set password=? where userId=?");
			ps.setString(1, newPassword);
			ps.setInt(2, userId);
			int k= ps.executeUpdate();
			if(k>0)
				flag=true;
			
				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.closeResultSet(rs);
			con.closePreparedStatement(ps);
			con.closeConnection();

		}
		return flag;
	}
	}
	
	


