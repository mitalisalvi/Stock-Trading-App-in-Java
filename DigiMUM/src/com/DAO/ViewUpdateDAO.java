package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Bean.Customer;
import com.Bean.TradeAccount;
import com.Connect.Connect;

public class ViewUpdateDAO {
	
	Connect c = new Connect();
	Connection con=null;
	PreparedStatement pst=null;
	ResultSet rs=null;
	
	

	public TradeAccount viewProfile (Customer cst)
	{
		TradeAccount trac =  new TradeAccount();
		
		c.getDriver();

		try
		{
			con=c.getConnection();
			pst=con.prepareStatement("select * from mm_tradeAccount where userId=?");
			pst.setInt(1,cst.getUserId());
			rs=pst.executeQuery();
			while (rs.next())
			{
				trac.setUserId(rs.getInt(1));
				trac.setBankId(rs.getInt(2));
				trac.setCashBalance(rs.getDouble(3));
				
				trac.setInvestment(rs.getDouble(4));
			}	
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			c.closeResultSet(rs);
			c.closePreparedStatement(pst);
			c.closeConnection();
		}
		
		return trac;
	}
	
	
	public boolean updateCustomer (Customer cd)
	{
		c.getDriver();
		
		int i=0;
		
		String s="update mm_customerdetails set firstName = ?, lastName=?, phoneNumber=?, secretAnswer=?, email=? where userId=?";
		
		try
		{
			con=c.getConnection();
			pst=con.prepareStatement(s);
			pst.setString(1, cd.getFirstName());
			pst.setString(2, cd.getLastName());
			pst.setLong(3, cd.getPhoneNumber());
			pst.setString(4, cd.getSecretAnswer());
			pst.setString(5, cd.getEmail());
			pst.setInt(6, cd.getUserId());
			i = pst.executeUpdate();
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			c.closeResultSet(rs);
			c.closePreparedStatement(pst);
			c.closeConnection();
		}
		if(i!=0)
		  return true;
		else return false;
	}
	
		
	public Customer updateProfile(Customer cst) 
	{
		Connect c = new Connect();
		
		c.getDriver();

		con = c.getConnection();

		try 
		{
			 pst = con.prepareStatement("select * from mm_customerdetails where userId=?");
			 pst.setInt(1, cst.getUserId());
			 rs = pst.executeQuery();
			 while (rs.next()) 
			 {
				cst.setUserId(rs.getInt("userId"));
				cst.setFirstName(rs.getString("firstName"));
				cst.setLastName(rs.getString("lastName"));
				cst.setDob(rs.getString("dob"));
				cst.setCountry(rs.getString("country"));
				cst.setPhoneNumber(rs.getLong("phoneNumber"));
				cst.setSecretAnswer(rs.getString("secretAnswer"));
				cst.setImage(rs.getString("image"));
			 }
		
	    }
	
	    catch(Exception e)
	    {}
  
		finally
		{
			c.closeResultSet(rs);
			c.closePreparedStatement(pst);
			c.closeConnection();
		}
		
	   return cst;

    }
	
	public boolean checkEmail(Customer cst) 
	{
		Connect c = new Connect();
		
		boolean flag =  true;
		
		c.getDriver();
         
		con = c.getConnection();
        
		try 
		{
			 pst = con.prepareStatement("select email from mm_customerdetails");
			 pst.setInt(1, cst.getUserId());
			 rs = pst.executeQuery();
			 while (rs.next()) 
			 {
				if(rs.getString(1).equals(cst.getEmail()))
					flag = false;
			 }

	    }
	
	    catch(Exception e)
	    {}
		
		finally
		{
			c.closeResultSet(rs);
			c.closePreparedStatement(pst);
			c.closeConnection();
		}
		
	   return flag;
    }
	
	public boolean checkPhoneNumber(Customer cst) 
	{
		Connect c = new Connect();
		
		boolean flag =  true;
		
		c.getDriver();
         
		con = c.getConnection();
        
		try 
		{
			 pst = con.prepareStatement("select phoneNumber from mm_customerdetails");
			 pst.setInt(1, cst.getUserId());
			 rs = pst.executeQuery();
			 while (rs.next()) 
			 {
				if(rs.getLong(1)==cst.getPhoneNumber())
					flag = false;
			 }

	    }
	
	    catch(Exception e)
	    {}
		
		finally
		{
			c.closeResultSet(rs);
			c.closePreparedStatement(pst);
			c.closeConnection();
		}
		
	   return flag;
    }
}