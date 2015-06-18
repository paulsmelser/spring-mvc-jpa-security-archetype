#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page pageEncoding="UTF-8"%>

<html>
<head>
  <title>Login</title>
  <link rel="stylesheet" type="text/css" href="resources/lib/bootstrap/css/bootstrap.min.css">
  <style>
  .error {
  padding: 15px;
  margin-bottom: 20px;
  border: 1px solid transparent;
  border-radius: 4px;
  color: ${symbol_pound}a94442;
  background-color: ${symbol_pound}f2dede;
  border-color: ${symbol_pound}ebccd1;
  }

  .msg {
  padding: 15px;
  margin-bottom: 20px;
  border: 1px solid transparent;
  border-radius: 4px;
  color: ${symbol_pound}31708f;
  background-color: ${symbol_pound}d9edf7;
  border-color: ${symbol_pound}bce8f1;
  }

  ${symbol_pound}login-box {
  width: 300px;
  padding: 20px;
  margin: 100px auto;
  background: ${symbol_pound}fff;
  -webkit-border-radius: 2px;
  -moz-border-radius: 2px;
  border: 1px solid ${symbol_pound}000;
  }
  </style>
</head>

<body>
<div id="login-box">
<form class="form-signin form-group" method="POST" action="<c:url value='/login'/>">
  <div class="form-signin-img">
    <span class="form-signin-img-helper"></span>
  </div>
  <h2 class="form-signin-heading">${symbol_dollar}{msg_heading}</h2>

  <c:if test="${symbol_dollar}{not empty msg_error}">
    <div class="alert alert-danger">
      <button type="button" class="close close-box">&times;</button>
      <p>${symbol_dollar}{msg_error}</p>
    </div>
  </c:if>
  <c:if test="${symbol_dollar}{not empty msg}">
    <p>${symbol_dollar}{msg}</p>
  </c:if>

  <input class="form-control" type="text" name="security_username" id="security_username" class="form-control" placeholder="${symbol_dollar}{msg_username}" required autofocus>
  <input type="password" name="security_password" id="security_password" class="form-control" placeholder="${symbol_dollar}{msg_password}" required>

  <button class="btn btn-lg btn-primary btn-block" type="submit">
    <i class="fa fa-sign-in fa-lg"></i>
    <span>login</span>
  </button>
</form>
</div>
</body>
</html>
