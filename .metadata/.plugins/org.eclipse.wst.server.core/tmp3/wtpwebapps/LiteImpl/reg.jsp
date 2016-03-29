<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">


</br></br>

	<img alt="Logo" src="logo.gif" align="left">
<ul class="nav nav-pills">
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
            <li><a href="#"></a></li>
			<li class="active"><a href="#">Home</a></li>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">Sign In</a></li>
		</ul>
		
	
		
		<h2>Welcome, please register</h2>
		</br></br>
	<form method="post" action="login.jsp">
		<div class="form-group">
			<label>First Name</label> <input type="text" class="form-control"
			name="firstname"placeholder="Enter Name">
		</div>
		<div class="form-group">
			<label>Last Name</label> <input type="text" class="form-control"
				placeholder="Enter Last Name">
		</div>
		
		<div class="form-group">
			<label>Email</label> <input type="text" class="form-control"
				placeholder="Enter Email">
		</div>
		
		<div class="form-group">
			<label>User Name</label> <input type="text" class="form-control"
				placeholder="Enter Username">
		</div>
		
		<div class="form-group">
			<label>Password</label> <input type="password" class="form-control"
				placeholder="Enter Passwords">
		</div>
		<button type="submit" class="btn">Submit</button><p>Not registered  <a href="registration.jsp">Click  Here</a></p>
	</form>
	</div>
    </body>
</html>