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
	height: 100%;
	background-image: linear-gradient(to top, #ff9a9e 0%, #fecfef 99%, #fecfef 100%);
}

#map {
	height: 400px;
	width: 100%;
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
					My profile<%=session.getAttribute("n")%></button></li>&nbsp;
			<li class="nav-item"><a href="logout.jsp" class="btn btn-danger">Logout</a></li>

		</ul>
	</div>


	</nav>




	<div class="modal" id="signup">
		<div class="modal-dialog">
			<div class="modal-content">

				Modal Header
				<div class="modal-header">
					<h4 class="modal-title">Enter Details!</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				Modal body
				<div class="modal-body">

					<form action="Myntraservlet" method="post">


						<div class="form-group">
							Enter name : <input type="text" name="f1" class="form-control">
						</div>
						<div class="form-group">
							Enter email : <input type="email" name="f2" class="form-control">
						</div>

						<div class="form-group">
							Enter password : <input type="password" name="f3"
								class="form-control">
						</div>
				</div>

				Modal footer
				<div class="modal-footer">

					<!-- <input type="submit" value="Register" name="bt" /> -->
					<button name="bt">Register</button>
				</div>

				</form>

			</div>
		</div>
	</div>



	<div class="modal" id="login">
		<div class="modal-dialog">
			<div class="modal-content">

				Modal Header
				<div class="modal-header">
					<h4 class="modal-title">Welcome!</h4>
					<button type="button" class="close" data-dismiss="modal">×</button>
				</div>

				Modal body
				<div class="modal-body">

					<form action="Redbusservlet" method="post">


						<div class="form-group">
							Enter email : <br> <input type="email" name="t1"
								class="form-control col-sm-6">
						</div>
						<br>

						<div class="form-group">
							Enter password : <br> <input type="password" name="t2"
								class="form-control col-sm-6">
						</div>
				</div>

				Modal footer
				<div class="modal-footer">
					<input type="submit" value="Login" name="bt" />


				</div>

				</form>

			</div>
		</div>
	</div>



	<br>
	<br>
	<br>
	<form action="Redbusservlet" method="post">

		<br> FROM &nbsp;&nbsp;&nbsp;&nbsp; <select name="from">
			<c:forEach var="obj" items="${cList}">
				<option>${obj}</option>
			</c:forEach>


		</select>


		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

		To &nbsp;&nbsp;&nbsp;&nbsp; <select name="to">
			<c:forEach var="obj" items="${cList}">
				<option>${obj}</option>
			</c:forEach>


		</select> <input type="submit" class="btn btn-primary" value="Book Ticket"
			name="bt"> <br> <br> <br>
		<div class="container">
			Position &nbsp;&nbsp;&nbsp;&nbsp; <select name="position"
				id="position">
				<option>Select City</option>
				<c:forEach var="obj" items="${cList}">
					<option>${obj}</option>
				</c:forEach>


			</select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit"
				class="btn btn-primary" value="Locate" name="bt" />
		</div>
		<br> <br>
		<input type="hidden" id="city" value="${city}" />
		<div class="container">
			<div id="map"></div>

			<script type="text/javascript">
				function initMap() {

					var location = document.getElementById("city").value
							.toUpperCase();

					console.log(location);

					if (location == "CHENNAI") {
						var coordinates = {
							lat : 13.0827,
							lng : 80.2707
						};
					} else if (location == "BANGLORE") {
						var coordinates = {
							lat : 12.9716,
							lng : 77.5946
						};
					} else if (location == "HYDERABAD") {
						var coordinates = {
							lat : 17.3850,
							lng : 78.4867
						};
					} else if (location == "KOCHI") {
						var coordinates = {
							lat : 9.9312,
							lng : 76.2673
						};
					} else if (location == "MUMBAI") {
						var coordinates = {
							lat : 19.0760,
							lng : 72.8777
						};
					} else if (location == "VIZAG") {
						var coordinates = {
							lat : 17.6868,
							lng : 83.2185
						};
					} else {
						var coordinates = {
							lat : 20.5937,
							lng : 78.9629
						};
					}

					var map = new google.maps.Map(document
							.getElementById('map'), {
						zoom : 7,
						center : coordinates
					});

					var marker = new google.maps.Marker({
						position : coordinates,
						map : map
					});
					var infowindow = new google.maps.InfoWindow({
						content : "Hello ${city}"
					});

					infowindow.open(map, marker);
				}
			</script>

			<script async defer
				src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDCC4UktmznnXlQpaiTx6HSLkuvdq9255E&callback=initMap">
				
			</script>
			

			<%--  <div class="container">
		 <table class="table table-hover">
			<tr>

				<th>Name</th>
				<th>Image</th>

			</tr>




			<c:forEach var="obj" items="${table}">
				<tr>
					<input type="hidden" value="${obj.id}" name="id">
					<td>${obj.name}</td>
					<td><img src="projectimages/${obj.image_url}"></td>


				</tr>
			</c:forEach>





		</table>
		</div> --%>
	</form>
	<br>
	<br>
	<br>
	<br>

</body>
</html>