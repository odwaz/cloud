<%@ page isErrorPage="true" %>

<html>
  <head>
    <title>Error</title>
  </head>
  <body>
    <h1>Oops, something went wrong!</h1>
    <%@include file="logo.html" %>
    <p>
      <b>Details: </b>${errMsg}
    </p>    
  </body>
</html>

