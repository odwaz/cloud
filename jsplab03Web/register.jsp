<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page errorPage="error.jsp" %>

<html>
  <head>
    <title>Registration Confirmation</title>
  </head>
  <body>
    <h1>Registration Confirmation</h1>
    <%@ include file="logo.html" %>
        
	    <p><b>Date:</b> ${regBean.date}</p>
	    <p><b>Confirmation number:</b> ${regBean.confirmationNumber}</p>
	    
	    
	    <h2>Billing Address</h2>
	    <p>${regBean.name}</p>
	    <p>${regBean.address}</p>
	    <p>${regBean.city} ${regBean.state} ${regBean.zip}</p>
	    
     <p><b>Amount due: </b> 
     <font color="red">
       ${regBean.amountDue}</p>
     </font>
  </body>
</html>  