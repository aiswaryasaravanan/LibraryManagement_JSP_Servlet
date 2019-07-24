<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<body>

	<a href="Logout">Logout</a>

 	<%	request.getRequestDispatcher("GetName").include(request, response); %>
	
	<h3>Welcome <%= request.getAttribute("name")%></h3>
	
	<button onclick="addStudentForm()">Add student</button>
	<button onclick="removeStudentForm()">Remove Student</button>
	<button onclick="addBookForm()">Add Book</button>
	<a href="GetAllUser"><button onclick="viewAllUser()">View All User</button></a>
 	<a href="GetAllBook"><button id="viewAllBook">View All Book</button></a>
 	<a href="GetIssuedBook"><button onclick="viewIssuedBook()">View Issued Books</button></a>
<!-- 	<a href="GetUserWithFine"><button onclick="viewUserWithFine()">View Users with Fine</button></a>
 -->	
	<br><br><br>
	<div id="content">
		<div id="addStudentForm" style="display:block">
			<form method="post" action="AddStudent">
				Enter StudentId:<br>
				<input type="text" name="id"><br>
			
				Enter name:<br>
				<input type="text" name="name"><br>
				
				 Enter Phone Number:<br>
				<input type="text" name="phoneno"><br>
				
				 Enter email:<br>
				<input type="text" name="email"><br>
				
				 Enter Address:<br>
				<input type="text" name="address"><br>
				 
				 <input type="submit" value="AddStudent">
			</form>
		</div>
		
		<div id="removeStudentForm" style="display:none">
			<form method="post" action="RemoveStudent" >
				Enter StudentId:<br>
				<input type="text" name="id"><br>
				<input type="submit" value="Remove student">
			</form>
		</div>
		
			<div id="addBookForm" style="display:none">
			<form method="post" action="AddBook">
				Enter BookId:<br>
				<input type="text" name="id"><br>
			
				Enter BookName:<br>
				<input type="text" name="name"><br>
				
				 Enter Author:<br>
				<input type="text" name="author"><br>
				
				 Enter TotalCount:<br>
				<input type="text" name="totalCount"><br>
				
				 Enter Cost:<br>
				<input type="text" name="cost"><br>
				 
				 <input type="submit" value="AddBook">
			</form>
		</div>
	</div>
	
	<script>
		function addStudentForm(){
			document.getElementById("addStudentForm").style.display="block";
			document.getElementById("removeStudentForm").style.display="none";
			document.getElementById("addBookForm").style.display="none";
			document.getElementById("getAllBook").style.display="none";
		}
		
		function removeStudentForm(){
			document.getElementById("addStudentForm").style.display="none";
 			document.getElementById("removeStudentForm").style.display="block";
			document.getElementById("addBookForm").style.display="none";
			document.getElementById("getAllBook").style.display="none";
   		}
		function addBookForm(){
			document.getElementById("addStudentForm").style.display="none";
			document.getElementById("removeStudentForm").style.display="none";
			document.getElementById("addBookForm").style.display="block";
			document.getElementById("getAllBook").style.display="none";
		}
/* 		$(document).ready(function(){
			$("#viewAllBook").click(function(){
			    $("#content").load("ViewAllBook.jsp");
			});
		}); */
		

	</script>
</body>
</html>