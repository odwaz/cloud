<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Example</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">


</br></br>
<ul class="nav nav-pills">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Services</a></li>
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">Sign In</a></li>
		</ul>
		
		<h2>Welcome, please Login or Register</h2>
		</br></br>
	<form method="post" action="login.jsp">
		<div class="form-group">
			<label>UserName</label> <input type="text" class="form-control"
				placeholder="Enter Name">
		</div>
		<div class="form-group">
			<label>Password</label> <input type="text" class="form-control"
				placeholder="Enter Email Address">
		</div>
		
		<button type="submit" class="btn">Submit</button><p>Not registered  <a href="registration.jsp">Click  Here</a></p>
	</form>
	</div>
</body>
</html>