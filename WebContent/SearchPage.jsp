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
		
	<form method="post" action="BorrowBook">
		<input type="radio" name="typeOfSearch" id="allAvailable" value="allAvailable" onclick="showAll()" checked>Show All Book<br>
		<input type="radio" name="typeOfSearch" id="bookName" value="byBook" onclick="showBook()">Search by Book Name<br>
		<input type="radio" name="typeOfSearch" id="authorName" value="byAuthor" onclick="showAuthor()">Search by Author Name<br><br>
		<div id="bookNameForm" style="display:none">
			Enter Book name:<input type="text" name="bookName"><br>
		</div>
		<div id="authorNameForm" style="display:none">
			Enter Author name:<input type="text" name="authorName"><br>
		</div>
		<input type="submit" value="submit">	
	</form>	
	
	<script>
		function showAll(){
			document.getElementById("bookNameForm").style.display="none";
			document.getElementById("authorNameForm").style.display="none";
		}
		function showBook(){
			document.getElementById("bookNameForm").style.display="block";
			document.getElementById("authorNameForm").style.display="none";
		}function showAuthor(){
			document.getElementById("bookNameForm").style.display="none";
			document.getElementById("authorNameForm").style.display="block";
		}
	</script>
	
	
</body>
</html>