package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.Bean.Customer;
import com.Bean.Stock;
import com.Bean.TradeAccount;
import com.Bean.Transaction;
import com.Connect.Connect;

public class TransactionDAO
{
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		ArrayList<Transaction> transactionList=new ArrayList<>();
		
		
		public Stock getStock(int id)
		{
			 Connect c = new Connect();
			  c.getDriver();
			  con = c.getConnection();
			  Stock res=new Stock();
			String s="select * from mm_stockmarket where stockid=?";
			try
		    {
		          ps=con.prepareStatement(s);
			      
		          ps.setInt(1,id);

			   rs=ps.executeQuery();
			   while(rs.next())
			   {
				   res.setStockId(rs.getLong("stockid"));
				   res.setStockSymbol(rs.getString("symbol"));
				   res.setStockName(rs.getString("stockname"));
				   res.setCurrentPrice(rs.getDouble("currentprice"));
				   res.setHigh52(rs.getDouble("high52"));
				   res.setLow52(rs.getDouble("low52"));
				   res.setChange(rs.getDouble("change"));
				   res.setLastChanged(rs.getDouble("lastclosed"));
				   res.setBuyingPrice(rs.getDouble("buyingprice"));
				   res.setSellingPrice(rs.getDouble("selligprice"));
				   res.setMarketType(rs.getString("markettype"));
				   
				   
			   }
		    
		    }
			
			catch (SQLException e)
		    {
				e.printStackTrace();
			}
				//String update="update mm_tradeaccount set cashbalance=? where  ";
			
			
		  
			finally
			{
				c.closeResultSet(rs);
				c.closePreparedStatement(ps);
				c.closeConnection();
			}
			return res;
					
		}
		
		public boolean doTransaction(Customer cst, Stock st, int quantity, String buySell)
		{
			  boolean flag  = false;
			  int i=0;
			  
			  Connect c = new Connect();
			  c.getDriver();
			  con = c.getConnection();
			  String insert = "insert into mm_transactions values(transactid.nextval,?,?,timestamp'?',?,?)";
			  
			  Date dd = new Date();
			  Timestamp tt= new Timestamp(dd.getYear(), dd.getMonth(), dd.getDay(), dd.getHours(), dd.getMinutes(), dd.getSeconds(), 0);
			try
		    {
		          ps=con.prepareStatement(insert);
			      
		          ps.setInt(1,cst.getUserId());
			      ps.setLong(2,st.getStockId());
			      ps.setTimestamp(3, tt);
			      ps.setInt(4,quantity);
			      ps.setString(5,buySell);
			      
		          i = ps.executeUpdate();
		          
		          if(i!=0)
		          {
		        	  flag=true;
		          }
		    }
			
			catch (SQLException e)
		    {
				e.printStackTrace();
			}
				//String update="update mm_tradeaccount set cashbalance=? where  ";
			
			
		  
			finally
			{
				c.closeResultSet(rs);
				c.closePreparedStatement(ps);
				c.closeConnection();
			}
			return flag;
	    }
		
		
		public ArrayList<Transaction> getTransaction (Customer cst)
		{
			Connect c = new Connect();
			  c.getDriver();
			  con = c.getConnection();
			  String get = "select * from mm_transactions where userid=?";
			  
			 
			try
		    {
		          ps=con.prepareStatement(get);
		          ps.setInt(1, cst.getUserId());
		          rs=ps.executeQuery();
		          while(rs.next())
		          {
		        	  Transaction tr=new Transaction();
		        	  tr.setTransactionId(rs.getInt("transactionid"));
		        	  tr.setUserId(rs.getInt("userid"));
		        	  tr.setStockId(rs.getLong("stockid"));
		        	  tr.setTimestampdate(rs.getTimestamp("timestampdate"));
		        	  tr.setQuantity(rs.getInt("quantity"));
		        	  tr.setBuySell(rs.getString("buysell"));
		        	  tr.setTradePrice(rs.getDouble("tradeprice"));
		        	  
		        	  transactionList.add(tr);
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
			return transactionList;
			
		}
}