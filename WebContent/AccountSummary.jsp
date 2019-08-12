<%@ page import="com.srkr.star.*,java.sql.*,com.mysql.jdbc.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
  <%String username =session.getAttribute("username").toString();%>
  <%String account =session.getAttribute("account").toString();%>
<body>
<P>Welcome <%= username %> </P>
<%  Account ac = new Account();
String balance = ac.getAccountSummary(account); %>
<p>Your Account balance is &nbsp <%=  balance %></p>
<br>
<a href ="javascript:history.go(-1)"onMouseOver="self.status.refferrer;return true"><font color="red">Back to Menu</font></a>
<br>
</body>
</html>