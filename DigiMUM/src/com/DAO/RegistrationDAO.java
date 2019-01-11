package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.Customer;
import com.Connect.Connect;

public class RegistrationDAO {

	PreparedStatement ps = null;
	Connection cc = null;
	ResultSet rs = null;
	Customer cs = null;

	public boolean insertCustomer(Customer cus, String userName, String password) {
		Connect con = new Connect();
		con.getDriver();
		boolean update = true;
		cc = con.getConnection();
		boolean flag = false;
		int userid = 0;

		try {
			ps = cc.prepareStatement("select username from mm_login");
			rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equals(userName)) {
					update = false;
					break;
				}
			}
			
			if (update) {
			
					ps = cc.prepareStatement("insert into mm_customerdetails(userId ,firstName,lastName,dob,country,phoneNumber,secretAnswer,email) values(userid.nextval,?,?,?,?,?,?,?)");

					ps.setString(1, cus.getFirstName());
					ps.setString(2, cus.getLastName());
					ps.setString(3, cus.getDob());
					ps.setString(4, cus.getCountry());
					ps.setLong(5, cus.getPhoneNumber());
					ps.setString(6, cus.getSecretAnswer());
					ps.setString(7, cus.getEmail());

					int k = ps.executeUpdate();
					if (k != 0)
						flag = true;
					ps = cc.prepareStatement("select userId from mm_customerdetails where phoneNumber=?");
					ps.setLong(1, cus.getPhoneNumber());
					rs = ps.executeQuery();
					while (rs.next()) {
						userid = rs.getInt(1);

					}

					if (flag == true) {
						ps = cc.prepareStatement("insert into mm_login values(?,?,?)");
						ps.setString(1, userName);
						ps.setInt(2, userid);
						ps.setString(3, password);
						ps.executeUpdate();

						
						ps = cc.prepareStatement("insert into mm_tradeaccount(userid,bankid) values(?,?)");
						ps.setInt(1, userid);
						ps.setInt(2,555);
						ps.executeUpdate();
					}
			
				
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
}