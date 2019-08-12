<%@ page import="com.srkr.star.*,java.sql.*,com.mysql.jdbc.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Creation</title>
</head>
<%
    String accountNumber = request.getParameter("accno");
    String name = request.getParameter("user");
    String password = request.getParameter("password");
    String amount = request.getParameter("amount");
    String email = request.getParameter("email");
    String contact = request.getParameter("contact");
    
    Account ac = new Account();
    boolean flag = ac.setAccount(accountNumber, amount, email, contact);
    Login ln = new Login();
    boolean flag1 = ln.setLogin(accountNumber,name,password);
    
    String result;
    String result1;
    
    if(flag)
    {
    	result = "Registration is Successfull";
    }
 
    else
    {
    	result = "Registration is failed";
    }
    
    if(flag1)
        	{
        	result1 = "Registration is Successfull";
        }
     
        else
        {
        	result1 = "Registration is failed";
        }
 %>
<body>
 <P>Your  <%= result %></P>
 <P>Your  <%= result1 %></P>
</body>
</html>