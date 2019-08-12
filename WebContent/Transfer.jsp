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
<div align="center">
<p>Transfer Amount </p>
<form action="TransferStatus.jsp" method="post">
Account Number           : <input type="text" name ="account" value = "" required="required"></br></br>
Receiver Name                : <input type="text" name ="user" value = "" required="required"></br></br>
Amount to be transferred : <input type="text" name="amount" value = "" required="required"></br></br>
<input type="submit" value="Transfer">
</form>
</div>
</body>
</html>