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

	<a href="Logout">Logout</a>
	
	<%@ page import="java.util.*,bean.transaction.Transaction" %>
	<%
		String s;
		request.setAttribute("status","current");
		request.getRequestDispatcher("GetMyBook").include(request, response);

		ArrayList<Transaction> transactions=(ArrayList<Transaction>)request.getAttribute("transactions");
		Iterator itr=transactions.iterator();
	%>
		<form action="UpdateOnReturn" method="post">
		<table width="100%">
			<tr><th></th><th>BookId</th><th>BookName</th><th>Author</th><th>IssueDate</th><th>DueDate</th></tr>
		<%
			while(itr.hasNext()){
				Transaction transaction=(Transaction)itr.next();
		%>
			<tr>
 				<td><input type="checkbox" name="transactionIds" value=<%=transaction.getTransactionId() %> ></td>
				<td><%=transaction.getBook().getBookId() %></td>
				<td><%= transaction.getBook().getBookName()%></td>
				<td><%= transaction.getBook().getAuthor()%></td>
				<td><%= transaction.getIssueDate()%></td>
				<td><%= transaction.getDueDate()%></td>
			</tr>
		<% 	}  %>		
		</table>
 
			<br><br>
			<input type="submit" value="Return Book">
		</form>
			
	
</body>
</html>