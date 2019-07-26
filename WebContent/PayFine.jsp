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
	
	
	<% 
		request.getRequestDispatcher("getFine").include(request, response);
	
		float fine=(float)request.getAttribute("fine");
	%>
	
	<br><br>
	Fine to be paid :<%= fine %> Rs.
	<br><br>
	<form method="post" action="SetFine">
		Enter Amount:<br>
		<input type="text" name="amount"><br>
 		<input type="hidden" name="fine" value=<%= fine %> >
 		<input type="submit" value="submit">
	</form>

</body>
</html>