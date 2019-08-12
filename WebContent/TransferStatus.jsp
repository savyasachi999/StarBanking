<%@ page import="com.srkr.star.*,java.sql.*,com.mysql.jdbc.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String sender =session.getAttribute("username").toString();%>
<%String senderaccount =session.getAttribute("account").toString();%>
<%
 String receiveraccount = request.getParameter("account");
 String receivername = request.getParameter("user");
 String amount = request.getParameter("amount");
 
  Account ac = new Account();
  String status = ac.transfer(senderaccount,receiveraccount,amount);
  %>
 <p><%= status %> to <%= receivername %></p>
 
 <a href ="javascript:history.go(-1)"onMouseOver="self.status.refferrer;return true"><font color="red">Back to Menu</font></a>
</body>
</html>