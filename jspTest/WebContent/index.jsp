<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>test attribute</title>

<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
</head>

<body>

		<h2>Home of the brave</h2>

		<p>${BuyBean.name}</p>
		<p>${BuyBean.lastname}</p>
		<p>${BuyBean.option}</p>

</body>
</html>
