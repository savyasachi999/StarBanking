package com.srkr.star;
import com.srkr.star.JdbcConnection;
import java.util.*;
import java.util.Date;
import java.sql.*;
import java.text.SimpleDateFormat;
import com.mysql.jdbc.Driver;

public class Account {

	
	
	 public boolean setAccount(String accountNumber,String amount,String email,String contact) 
	    {
		  boolean flag;
	    	try
	    	{
	       	JdbcConnection jc = new JdbcConnection();
	       	Connection con = jc.getConnection();
        PreparedStatement ps =  con.prepareStatement("INSERT INTO account(account,amount,email,contact)"
		+ " VALUES ('"+accountNumber+"','"+amount+"','"+email+"','"+contact+"')");
		    ps.executeUpdate();
		    return flag = true;
	    	}
	    	catch(Exception e)
	    	{
	        System.out.println(e);
	        
	    	}
	    	
	    	return flag = false;
	    }
	 
	  public String transfer(String sender,String receiver,String amount)
	  {  
		  String senderBalance;
		  String receiverBalance;
		  String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		  String type;
		  
		  try
		  {
		  JdbcConnection jc = new JdbcConnection();
	      Connection con = jc.getConnection();
	      Statement st =  con.createStatement();
	      ResultSet send = st.executeQuery("select * from account where account='"+sender+"'");
	            
	      
	      if(send.next())
		    {
	    	   type="debit";
		       senderBalance = send.getString(2);
		       double senderAmount=Double.parseDouble(senderBalance)-Double.parseDouble(amount);
		  	   String senderFinal=Double.toString(senderAmount);
		  	   st.executeUpdate("update account set amount='"+senderFinal+"'where account='"+sender+"'");
		  	   System.out.println("Im in sender block");
		  	   PreparedStatement ps =  con.prepareStatement("INSERT INTO transaction(account,amount,type,date)"
		  			+ " VALUES ('"+sender+"','"+amount+"','"+type+"','"+date+"')");
		  			    ps.executeUpdate();
		  	 		  
		    }
	      
	      ResultSet receive = st.executeQuery("select * from account where account='"+receiver+"'");
	      
	      if(receive.next())
	      {
	    	   type="credit";
		    	receiverBalance = receive.getString(2);
		    	double receiverAmount=Double.parseDouble(receiverBalance)+Double.parseDouble(amount);
		  	    String receiverFinal=Double.toString(receiverAmount);
		  	    st.executeUpdate("update account set amount='"+receiverFinal+"'where account='"+receiver+"'");
		  	    System.out.println("Im in receiver block");
		  	    PreparedStatement ps =  con.prepareStatement("INSERT INTO transaction(account,amount,type,date)"
			  			+ " VALUES ('"+receiver+"','"+amount+"','"+type+"','"+date+"')");
			  			    ps.executeUpdate();
	      }
	      
	        return "Transfered Successfully ";
	      
	      
		  }
		  catch(Exception E)
		  {
			System.out.println(E);
		  }
		  return "Transfer failed";
	  }
	  
	  public String getAccountSummary(String account)
	  {
		  String amount = null;
		  try
		  {
		  JdbcConnection jc = new JdbcConnection();
	      Connection con = jc.getConnection();
	      Statement st =  con.createStatement();
	      ResultSet rs = st.executeQuery("select * from account where account='"+account+"'");
	      
		    if(rs.next())
		    {
		    	amount = rs.getString(2);
		    }
		    
		    return amount;
		  }
		  catch(Exception e)
		  {
			 System.out.println(e); 
		  }
		   return "Failed to connect";
	  }
	  
	public ResultSet getMiniStatement(String account)
	{
		try
		  {
		  JdbcConnection jc = new JdbcConnection();
	      Connection con = jc.getConnection();
	      Statement st =  con.createStatement();
	      ResultSet rs = st.executeQuery("select * from transaction where account='"+account+"'");
	      
	       return rs;
		  }
		 catch(Exception e)
		  {
			 System.out.println(e); 
		  }
		return null;
	}
}
