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
<%String username =session.getAttribute("username").toString();%>
 <%String account =session.getAttribute("account").toString();%>
<body>
<P>Welcome <%= username %> </P>
<%  Account ac = new Account();
    ResultSet rs=ac.getMiniStatement(account);
 %>
 <table border="1">
   <tbody>
     <tr>
       <td>Amount</td>
       <td>Type</td>
       <td>Date</td>
      </tr>
    <% while(rs.next()) { %>
     <tr>
       <td><%= rs.getString(2)%></td>  
       <td><%= rs.getString(3)%></td>
       <td><%= rs.getString(4)%></td>
      </tr>
      <% } %>
     </tbody>  
 </table>
 <a href ="javascript:history.go(-1)"onMouseOver="self.status.refferrer;return true"><font color="red">Back to Menu</font></a>
 </body>
</html>