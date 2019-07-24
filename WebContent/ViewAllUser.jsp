<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table,tr,th,td{
	border:1px solid black
}
</style>

</head>
<body>
	<%@page import="java.util.ArrayList,java.util.Iterator,bean.user.User" %>
	<%
		ArrayList<User> users=(ArrayList<User>)request.getAttribute("users");
		Iterator itr=users.iterator();	%>
		<table width="100%">
		<tr><th>StudentId</th><th>StudentName</th><th>PhoneNo</th><th>email</th><th>Address</th><th>FineAmount</th></tr>		
	<%	while(itr.hasNext()){
			User user=(User)itr.next();	%>
			<tr><td><%=user.getId() %></td><td><%=user.getName() %></td><td><%=user.getPhoneNo() %></td><td><%=user.getEmail() %></td><td><%=user.getAddress() %></td><td><%=user.getFineAmount() %></td></tr>		
	<%		
		}
	%></table>
</body>
</html>