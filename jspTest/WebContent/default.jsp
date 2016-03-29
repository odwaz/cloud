<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>test attribute</title>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>

<form method=post action="index.jsp" name=form1 class="form-group">
	<select name="page1" class="form-control">
		<option class="form-control">first</option>
		<option class="form-control">second</option>
		<option class="form-control">third</option>
	</select><br> <br> Enter your username : <input type=text
		class="form-control" name="testuid">
	<p>
		Enter your lastname : <input type=text name="testupwd"
			class="form-control">
	<p>
		<input type=submit value="submit">
</form>
</html>
