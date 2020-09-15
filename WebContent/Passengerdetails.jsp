<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
body {

	height : 100vh;
	background-image: linear-gradient(to top, #ff9a9e 0%, #fecfef 99%, #fecfef 100%);
}
</style>
</head>
<body>
	<nav class="navbar bg-danger">

	<div class="container">

		<img src="projectimages/Redbus.jpeg"
			style="height: 60px; width: 60px;">


		<ul class="nav">
			<li class="nav-item"><button class="btn btn-primary"
					data-toggle="modal" data-target="#login">
					Myprofile
					<%=session.getAttribute("n")%></button></li>&nbsp;
		<li class="nav-item"><a href="logout.jsp" class="btn btn-danger">Logout</a></li>

		</ul>
	</div>


	</nav>
	FROM :<h2><%=session.getAttribute("from")%></h2>
	To :<h2><%=session.getAttribute("to")%></h2>
	<div class="container">
	<form action="Redbusservlet" method="post">
	
		<table class="table table-hover">
			<tr>
				<th>Name</th>
				<th>Gender</th>
				
				<th>Age</th>
				<th>Category</th>
</tr>
			<c:forEach var="obj" items="${plist}" varStatus="st">

				<tr>
					<td>${obj.getName()}</td>
					<td>${obj.getGender()}</td>
					<td>${obj.getAge()}</td>
					<td>${obj.getCategory()}</td>
					
					
					
				</tr>
				</c:forEach>
</table>

		<center>
			<h2 name="tp">Total Price: ${totalprice}</h2>
			<br> <br> <input type="submit" class="btn btn-primary"
				value="Makepayment" name="bt"> <br> <br>

		</center>
			
	</form>

</div>








</body>
</html>