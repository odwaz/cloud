<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean class="order.Order" id="theOrder" scope="session"/>

<jsp:setProperty name="theOrder" property="name" value="${param.name}"/>
<jsp:setProperty name="theOrder" property="address" value="${param.address}"/>
<jsp:setProperty name="theOrder" property="email" value="${param.email}"/>

<html>
  <body>
    <img alt="Logo" src="logo.gif">
    <h2>Address and Payment Confirmation</h2>
    
      <table>
        <tr>
            <td valign="top">
            <table>
                <tr>
                    <td align="left">Name: </td>
                    <td align="left"><input type="text" size="25" maxlength="25" name="name"></td>
                </tr>
                <tr>
                    <td align="left">Address: </td>
                    <td align="right"><input type="text" size="25" maxlength="25" name="address"></td>
                </tr>
                <tr>
                    <td align="left">City: </td>
                    <td align="right"><input type="text" size="25" maxlength="25" name="city"></td>
                </tr>
                <tr>
                    <td>State:</td>
                    <td><input type="text" size="2" maxlength="2" name="state"></td>
                </tr>
                <tr>
                    <td>Zip:</td>
                    <td><input type="text" size="5" maxlength="5" name="zip"></td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Submit" onclick="index.jsp">
                        <input type="Reset">
                    </td>
                </tr>
            </table>
            </td>

            <td width="5%">
            </td>

            <td valign="top">
            <table>
            
            </table>
            </td>

        </tr>
    </table>
    
     
  </body>
</html>
