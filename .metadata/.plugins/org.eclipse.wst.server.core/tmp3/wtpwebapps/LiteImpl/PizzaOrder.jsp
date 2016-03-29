<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<jsp:useBean class="order.Order" id="theOrder" scope="session"/>

<jsp:setProperty name="theOrder" property="size" value="${param.size}"/>
<jsp:setProperty name="theOrder" property="beef" value="${not empty param.beef}"/>
<jsp:setProperty name="theOrder" property="mushrooms" value="${not empty param.mushrooms}"/>
<jsp:setProperty name="theOrder" property="sausage" value="${not empty param.sausage}"/>
<html>
  <body>
    <img alt="Logo" src="logo.gif">
    <h2>Configure Your Pizza, Step 2!</h2>
    <p>
      Price for selected ingredients: ${theOrder.price}
    </p>
    <h3>Enter Delivery Info</h3>
    
    <c:url value="AddressInfo.jsp" var="url"/>
    
    <form action="${url}">
      <table border="0">
        <tr>
          <td>Name:</td>
          <td><input type="text" name="name"></td>
        </tr>
        <tr>
          <td>Address:</td>
          <td><input type="text" name="address"></td>
        </tr>
        
        <tr>
          <td>Email:</td>
          <td><input type="text" name="email"></td>
        </tr>
        <tr>
          <td><input type="submit" value="Next..."></td>
        </tr>
      </table>
    </form>
  </body>
</html>