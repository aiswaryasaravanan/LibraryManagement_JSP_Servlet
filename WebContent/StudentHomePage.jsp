<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="Logout">Logout</a>
 	<%	request.getRequestDispatcher("GetName").include(request, response); %>
	
	<h3>Welcome <%= request.getAttribute("name")%></h3>
		<a href="ViewProfile">View Profile</a><br>
		<a href="SearchPage">Borrow Book</a><br>
		<a href="ReturnBook">Return Book</a><br>
		<a href="RenewBook">Renew Book</a><br>
		<a href="PayFine">Pay Fine</a><br>
</body>
</html>