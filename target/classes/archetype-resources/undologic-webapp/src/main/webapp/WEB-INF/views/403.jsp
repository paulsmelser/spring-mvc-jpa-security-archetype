#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
<h1>HTTP Status 403 - Access is denied</h1>

<c:choose>
  <c:when test="${symbol_dollar}{empty username}">
    <h2>You do not have permission to access this page!</h2>
  </c:when>
  <c:otherwise>
    <h2>Username : ${symbol_dollar}{username} <br/>
      You do not have permission to access this page!</h2>
  </c:otherwise>
</c:choose>

</body>
</html>
