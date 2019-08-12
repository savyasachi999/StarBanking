package com.srkr.star;

import java.sql.*;

public class Login {

	private boolean flag;
	String account;
	
	 public boolean setLogin(String accountNumber,String userName,String password)
	 {
		 try
	    	{
	       	JdbcConnection jc = new JdbcConnection();
	    	Connection con = jc.getConnection();
PreparedStatement ps =  con.prepareStatement("INSERT INTO login(account,username,password)"+"VALUES ('"+accountNumber+"','"+userName+"','"+password+"')");
		    ps.executeUpdate();
		    return flag = true;
	    	}
	    	catch(Exception e)
	    	{
	        System.out.println(e);
	        
	    	}
	    	
	    	return flag = false;
	 }
	 
	 public String login(String username,String password) 
	    {
		 
		 
		 
	    	try
	    	{
	    	
	    	JdbcConnection jc = new JdbcConnection();
	    	Connection con = jc.getConnection();
	    	
	    	Statement st =  con.createStatement();
	ResultSet rs = st.executeQuery("select * from login where username='"+username+"'");
		    if(rs.next())
		    { 
		    	
		    	if(rs.getString(3).equals(password))
		    	{
		    		 account = rs.getString(1);
		    	}
		    	 return account;    
		    }
		   
	    	}
	    	catch(Exception e)
	    	{
	        System.out.println(e);
	        
	    	}
	    	
	    	return "failed";
	    }
	 
	 public String changePassword(String account,String existingPassword,String newPassword)
	 {
		 try
	    	{
	       	JdbcConnection jc = new JdbcConnection();
	    	Connection con = jc.getConnection();
	    	Statement st =  con.createStatement();
	    	ResultSet rs = st.executeQuery("select * from login where account='"+account+"'");
	    	if(rs.next())
		    { 
		    	
		    	if(rs.getString(3).equals(existingPassword))
		    	{
	    	      st.executeUpdate("update login set password='"+newPassword+"'where account='"+account+"'");
		    	}
		    }
	    	return "Success";
	    	}
		 catch(Exception e)
	    	{
	        System.out.println(e);
	        
	    	}
	    	
	    	return "failed";
 }
}
