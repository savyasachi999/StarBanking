package com.srkr.star;
import com.mysql.*;
import java.sql.*;

public class Register {
	
	private String accountNumber;
    private String name;
    private String password;
    private boolean flag;
    
    public boolean setLogin(String accNo,String username,String password) 
    {
    	try
    	{
    	JdbcConnection jc = new JdbcConnection();
    	Connection con =jc.getConnection();
    	PreparedStatement ps = con.prepareStatement("INSERT INTO login(account,username,password) VALUES ('"+accNo+"','"+username+"','"+password+"')");
	    ps.executeUpdate();
	    flag = true;
    	}
    	catch(Exception e)
    	{
        System.out.println(e);
        flag = false;
    	}
    	
    	return flag;
    }
}
