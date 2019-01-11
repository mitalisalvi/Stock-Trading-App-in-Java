package com.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	private static final String username="aja131core";
	private static final String password="aja131core";
	private static final String hostname="INGNRGPILPHP01";
	private static final String port="1521";
	private static final String database="ORCLILP";
	private static final String driver="oracle.jdbc.driver.OracleDriver";
	private Connection con = null;
	private String url="jdbc:oracle:thin:@"+hostname+":"+port+":"+database;
	
	public void getDriver()
	{
		try
		{
		Class.forName(driver);
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() 
	{
		closeConnection();
		
		try
		{
			con=DriverManager.getConnection(url,username,password);			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
	public void closeConnection()
	{
		try
		{
			if(con!=null)
				con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void closeResultSet(ResultSet rs)
	{
		try
		{
			if(rs!=null)
				rs.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void closeStatement(Statement st)
	{
		try
		{
			if(st!=null)
				st.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void closePreparedStatement(PreparedStatement pst)
	{
		try
		{
			if(pst!=null)
				pst.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
