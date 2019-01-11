package com.DAO;

import com.Bean.Alert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.Connect.Connect;

public class SetAlertDAO {
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;

	public long getStockID(String symbol) {
		Connect c = new Connect();
		c.getDriver();
		con = c.getConnection();
		long stockId = 0;
		System.out.println(symbol);
		try {
			String s="select stockid from MM_STOCKMARKET where symbol='"+symbol+"'";
			System.out.println(s);
			ps = con.prepareStatement(s);
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				stockId = rs.getInt(1);
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.closeResultSet(rs);
			c.closePreparedStatement(ps);
			c.closeConnection();
		}
		return stockId;
	}

	public boolean setAlertDAO(Alert a) {
		Connect c = new Connect();
		c.getDriver();
		con = c.getConnection();
		boolean flag = false;
		try {
			ps = con.prepareStatement("insert into MM_ALERTS values(?,?,?,?)");
			ps.setInt(1, a.getUserId());
			ps.setLong(2, a.getStockId());
			ps.setDouble(3,a.getPrice());
			ps.setInt(4,a.getSign());
			int k = ps.executeUpdate();
			if (k != 0)
				flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			c.closeResultSet(rs);
			c.closePreparedStatement(ps);
			c.closeConnection();
		}
		return flag;
	}

}
