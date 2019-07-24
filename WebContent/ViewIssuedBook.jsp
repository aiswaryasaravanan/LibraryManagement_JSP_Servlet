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
	<%@page import="java.util.ArrayList,java.util.Iterator,bean.transaction.*" %>
	<%
		ArrayList<Transaction> transactions=(ArrayList<Transaction>)request.getAttribute("transactions");
		Iterator itr=transactions.iterator();
	%>
	<table width="100%">
		<tr><th>BookId</th><th>BookName</th><th>UserId</th><th>userName</th><th>issueDate</th><th>DueDate</th></tr>
	<% 	
		while(itr.hasNext()){
			Transaction transaction=(Transaction)itr.next();
	%>
		<tr>
			<td><%=transaction.getBook().getBookId() %></td><td><%=transaction.getBook().getBookName() %></td>
			<td><%=transaction.getUser().getId() %></td><td><%=transaction.getUser().getName() %></td>
			<td><%=transaction.getIssueDate() %></td><td><%=transaction.getDueDate() %></td>
		</tr>

	<% 	}
	%>
	</table>
	
</body>
</html>