<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
<center>
 <h1>YOUR PAYMENT IS SUCESSFULL</h1>
 <h2>HAPPY JOURNEY :)</h2>
</center>
<center>
FROM :<%=session.getAttribute("from")%>
	To :<%=session.getAttribute("to")%>

</center>
<form action="Redbusservlet" method="post">
<center>
		<input type="submit" value="Home" name="bt" class="btn btn-primary">
		</center>
		</form>
</body>
</html>