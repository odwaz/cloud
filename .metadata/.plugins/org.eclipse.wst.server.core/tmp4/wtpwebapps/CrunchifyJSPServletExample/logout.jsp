<%
	session.removeAttribute("username");
	session.removeAttribute("type");
	session.removeAttribute("Data");
	//session.invalidate();
	response.sendRedirect("index.jsp");
%>