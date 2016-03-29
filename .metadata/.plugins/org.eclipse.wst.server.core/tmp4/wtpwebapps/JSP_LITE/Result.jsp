<%@ page language="java" contentType="text/html; charset=US-ASCII" pageEncoding="US-ASCII"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
	<title>Success URL</title>
</head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<link rel="stylesheet" type="text/css" href="Stylesheet.css">
<body class="clsMain">
<%
	String pageHeading = "Successfull";
	switch (Integer.parseInt(request.getParameter("LITE_PAYMENT_CARD_STATUS")))
	{
		case 0:
			break;
		case 1:
		case 2:
		case 5:
		case 9:
			pageHeading = "Trylater";
			break;
		case 255:
			pageHeading = "Error";
			break;
		default:
			pageHeading = "Fail";
			break;
	}
%>
<p align="center" class="clsHeading">Page Result: <%= pageHeading %></p>
<table align="center" class="clsQuery" cellspacing="0">
	<tr>
		<td align="center" class="clsQueryHeading">Parameter</td>
		<td align="center" class="clsQueryHeading">Value</td>
	</tr>
	<tr>
		<td align="center" class="clsQueryHeading"><nobr>LITE_PAYMENT_CARD_STATUS (Error Code)</nobr></td>
		<td align="center" class="clsQuery"><nobr><%=request.getParameter("LITE_PAYMENT_CARD_STATUS")%></nobr></td>
	</tr>
	<tr>
		<td align="center" class="clsQueryHeading"><nobr>Description</nobr></td>
		<td align="center" class="clsQuery"><nobr><%=request.getParameter("LITE_RESULT_DESCRIPTION")%></nobr></td>
	</tr>
</table>
<p align="center" class="clsHeading">Form variables</p>
<table align="center" class="clsQuery" cellspacing="0">
	<tr>
		<td align="center" class="clsQueryHeading">Parameter</td>
		<td align="center" class="clsQueryHeading">Value</td>
	</tr>
<%
	String paramName = null;
	Enumeration params = request.getParameterNames();
	
	while (params.hasMoreElements()) {
		paramName = params.nextElement().toString().trim();
%>
	<tr>
		<td align="center" class="clsQueryHeading"><%=paramName%></td>
		<td align="center" class="clsQuery"><%=request.getParameter(paramName)%></td>
	</tr>
<% 
	}
%>
</table>
</body>
</html>