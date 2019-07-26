<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<style>
table,tr,th,td{
	border:1px solid black
}
</style>
</head>
<body>
	<%@page import="java.util.ArrayList,java.util.Iterator,bean.book.Book" %>

	<a href="Logout">Logout</a>

	<h4>Name:</h4><% request.getRequestDispatcher("GetName").include(request,response);%>
					<%=request.getAttribute("name") %>	<br><br>
	<h4>Id:</h4><%=session.getAttribute("id")%><br><br>
	<h4>Books yet to Return:</h4></h4><br>
 
	<%
		request.setAttribute("status","current");
		request.getRequestDispatcher("GetMyBook").include(request, response);

		ArrayList<bean.transaction.Transaction> transactions=(ArrayList<bean.transaction.Transaction>)request.getAttribute("transactions");
		Iterator itr=transactions.iterator();
	%>
		<table width="100%">
			<tr><th>BookId</th><th>BookName</th><th>Author</th><th>IssueDate</th><th>DueDate</th></tr>
		<% 	while(itr.hasNext()){
				bean.transaction.Transaction transaction=(bean.transaction.Transaction)itr.next();
		%>
			<tr>
				<td><%=transaction.getBook().getBookId() %></td>
				<td><%=transaction.getBook().getBookName() %></td>
				<td><%=transaction.getBook().getAuthor() %></td>
				<td><%=transaction.getIssueDate() %></td>
				<td><%=transaction.getDueDate() %></td>
			</tr>
		<% 	}
		%>
		</table>
			

	<br>
	<h4>History:</h4><br>
 
 	<%
 		request.setAttribute("status","past");
 	 	request.getRequestDispatcher("GetMyBook").include(request, response);

 	 	ArrayList<bean.transaction.Transaction> transactions1=(ArrayList<bean.transaction.Transaction>)request.getAttribute("transactions");
 	 	Iterator itr1=transactions1.iterator();
	%>
	<table width="100%">
		<tr><th>BookId</th><th>BookName</th><th>Author</th><th>IssueDate</th><th>DueDate</th></tr>
	
	<%
 	 	while(itr1.hasNext()){
 	 	 	bean.transaction.Transaction transaction=(bean.transaction.Transaction)itr1.next();
 	 %>
 	 			<tr>
				<td><%=transaction.getBook().getBookId() %></td>
				<td><%=transaction.getBook().getBookName() %></td>
				<td><%=transaction.getBook().getAuthor() %></td>
				<td><%=transaction.getIssueDate() %></td>
				<td><%=transaction.getDueDate() %></td>
			</tr>
 	<% 	}
 	%>
	</table>
 
	<br>
	<h4>Fine to be Paid:</h4>
	<%
		request.getRequestDispatcher("getFine").include(request, response);
	%>
	<%=request.getAttribute("fine") %>
</body>
</html>