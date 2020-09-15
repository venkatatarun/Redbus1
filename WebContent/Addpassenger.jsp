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
	background-image: linear-gradient(to bottom, #99ff99 0%, #33ccff 100%)
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
					Welcome
					<%=session.getAttribute("n")%></button></li>&nbsp;
			<li class="nav-item"><a href="logout.jsp" class="btn btn-danger">Logout</a></li>


		</ul>
	</div>


	</nav>
	<ceneter>
	FROM :<h2><%=session.getAttribute("from")%></h2>
	<br>
	<br>
	TO : :<h2><%=session.getAttribute("to")%></h2>
	</ceneter>
	<center>
		<button class="btn btn-primary" data-toggle="modal"
			data-target="#Addpassenger">Addpassenger</button>
	</center>
	<center>
		<h1>Passenger Details</h1>
	</center>
	<div class="modal" id="Addpassenger">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Enter Details!</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<form action="Redbusservlet" method="post">


						<div class="form-group">
							Enter name : <input type="text" name="t1" class="form-control">

						</div>
						<div class="form-group">
							Enter age: <input type="number" name="t2" class="form-control">
						</div>

						<div class="form-group">
							Enter gender: <input type="radio" name="t4" value="male"
								> Male <input
								type="radio" name="t4" value="female" >
							Female
						</div>
						<div class="form-group">
							Enter Category: <input type="radio" name="t5" value="Express"
								> <label for="Express">Express</label>

							<input type="radio" name="t5" value="Superluxury"
								> <label for="Superluxury">Super-Luxury</label>
						</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">

					<input type="submit" value="Add" name="bt" />
				</div>

				</form>

			</div>
		</div>
	</div>
     <div class="container">
	 <table class="table table-hover">
		<tr>
			<th>ID</th>

			<th>Name</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Category</th>



		</tr>
		<c:forEach var="obj" items="${plist}" >

			<tr>
				<td>${obj.id}</td>
				
				<td class="name">${obj.getName()}</td>
				<td>${obj.getGender()}</td>
				<td>${obj.getAge()}</td>
				<td>${obj.getCategory()}</td>
				
			
				
			</tr>





		</c:forEach>
	</table>
	</div>
	<center>
	<form action="Redbusservlet" method="post">
		<input type="submit" value="Proceedtopayment" name="bt"
			class="btn btn-primary"></form>
	</center>
	
	
	
	

</body>
</html>