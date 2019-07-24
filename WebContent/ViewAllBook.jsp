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

	<%@page import="java.util.ArrayList,java.util.Iterator,bean.book.Book" %>
	<%
		ArrayList<Book> books=(ArrayList<Book>)request.getAttribute("books");
		Iterator itr=books.iterator();
	%>
	<table width="100%">
		<tr><th>BookId</th><th>BookName</th><th>Author</th><th>AvailableCount</th><th>TotalCount</th><th>cost</th></tr>
	<%	
		while(itr.hasNext()){
			Book book=(Book)itr.next();
	%>
			<tr><td><%=book.getBookId() %></td><td><%=book.getBookName() %></td><td><%=book.getAuthor() %></td><td>book.getAvailableCount()</td><td><%=book.getTotalCount() %></td><td><%=book.getCost() %></td></tr>
	<% 		
		}
	%>
	</table>
	


</body>
</html>