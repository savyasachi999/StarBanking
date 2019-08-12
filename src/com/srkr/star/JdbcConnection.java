package com.srkr.star;

import java.sql.Connection;
import java.sql.DriverManager;


public class JdbcConnection {

	 
	public String driver = "com.mysql.jdbc.Driver";
	public String url = "jdbc:mysql://localhost:3306/testdb";
	public String username = "root";
	public String password = "admin";
	public Connection con;
	
	
	public Connection getConnection()
	{
		
		try
		{
		
			Class.forName(driver);
			//System.out.println("iam here");
			Connection con = DriverManager.getConnection(url,username,password);
			System.out.println("connected");
			return con;			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;		
	}
	 public static void main(String args[])
	  {
		 JdbcConnection jc = new JdbcConnection();
	    	Connection con = jc.getConnection();
	    	System.out.println(con);
      }
}