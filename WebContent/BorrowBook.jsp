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
table{
	border-collapse:collapse,
}
</style>
</head>
<body>

	<%@ page import="java.util.ArrayList,java.util.Iterator,bean.book.Book" %>
	<%
		request.setAttribute("bookName",request.getParameter("bookName"));
		request.setAttribute("authorName",request.getParameter("authorName"));
		request.setAttribute("typeOfSearch",request.getParameter("typeOfSearch"));
		
		request.getRequestDispatcher("GetBook").include(request, response);
		ArrayList<Book> books=(ArrayList<Book>)request.getAttribute("books");
		String s;
		Iterator itr=books.iterator();
	%>
	<form action="UpdateOnBorrow" method="post">
	<table width="100%">
	<tr><th></th><th>BookId</th><th>BookName</th><th>Author</th><th>AvailableCount</th></tr>
	<%
		while(itr.hasNext()){
		Book book=(Book)itr.next();
	%>
		<tr>
			<td><input type="checkbox" name="bookIds" value=<%=book.getBookId() %> ></td>
			<td><%=book.getBookId() %></td>
			<td><%=book.getBookName() %></td>
			<td><%=book.getAuthor() %></td>
			<td><%=book.getAvailableCount() %></td>
			
		</tr>
	<% 
		}
	%>
	</table>

			<br><input type="submit" value="submit">
	</form>
</body>
</html>