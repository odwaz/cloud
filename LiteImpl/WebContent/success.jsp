<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
<head>
<title>Register for the Conference</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>

<body>

	<div class="container">

		<div class="jumbotron">
			<h1>Hello, world!</h1>
			<p>This is an example to show the potential of an offcanvas
				layout pattern in Bootstrap. Try some responsive-range viewport
				sizes to see it in action.</p>
		</div>
		
		
		<form action="InsertRegistration" method="post">
		
		<div class="form-group">
			<label>First Name</label> <input type="text" class="form-control" value="<%=request.getParameter("")%>">
		</div>
			USER ID<input type=text
				value="<%=request.getParameter("testuid")%>disabled"> <br>
			Name <input type="text"
				value=" <%=request.getParameter("testupwd")%>" disabled> <br>
			Another <input type=text value="<%=request.getParameter("page1")%>"
				disabled> <br> Home <input type=text
				value="<%=request.getParameter("testuid")%>" disabled>

		</form>
	</div>
</body>
</html>
