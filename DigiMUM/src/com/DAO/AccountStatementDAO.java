package com.DAO;
import java.util.ArrayList;
import com.Bean.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Bean.AccountStatement;
import com.Bean.Customer;
import com.Bean.Transaction;
import com.Connect.Connect;

public class AccountStatementDAO {
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;

	public AccountStatement getAccountStatement(Customer cst,String fDate,String tDate) {
		AccountStatement acst = new AccountStatement();
		ArrayList<Transaction> t=new ArrayList<>();
		Connect c = new Connect();
		c.getDriver();

		acst.setUserId(cst.getUserId());

		con = c.getConnection();


		try {
			ps = con.prepareStatement("select * from mm_transactions where userId = ? AND timestampdate >= timestamp'"+fDate+" 00:00:00' AND timestampdate <= timestamp'"+tDate+" 00:00:00'");
			ps.setInt(1, cst.getUserId());
			rs = ps.executeQuery();
			while (rs.next()) {
				Transaction tr = new Transaction();
				tr.setTransactionId(rs.getInt(1));
				
				tr.setUserId(rs.getInt(2));
				tr.setStockId(rs.getInt(3));
				tr.setTimestampdate(rs.getTimestamp(4));
				tr.setQuantity(rs.getInt(5));
				tr.setBuySell(rs.getString(6));
				t.add(tr);
				}
			acst.setTransactions(t);
			
			ps = con.prepareStatement("select cashbalance from mm_tradeAccount where userId = ?");
			ps.setInt(1, cst.getUserId());
			rs = ps.executeQuery();
			while (rs.next()) {
			acst.setCurrentBalance(rs.getDouble(1));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			c.closeResultSet(rs);
			c.closePreparedStatement(ps);
			c.closeConnection();
		}

		
		return acst;
	}
}