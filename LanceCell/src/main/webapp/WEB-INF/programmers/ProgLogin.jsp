<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Programmer Login</title>
</head>
<body>
<div class="form2" style="margin-left:40px">
		<h3 style="margin-left : 15%;font-weight:bold">Log In</h3>
		<form:form action="/login" method="post" modelAttribute="newLogin"  style="width : 400px;margin-left : 15%;">
		  <div class="form-group">
		    <form:label path="email" for="exampleInputEmail1">Email </form:label>
		    <form:errors path="email"/>
		    <form:input path="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"></form:input>
		  </div>
		  <div class="form-group">
		    <form:label path="password" for="exampleInputPassword1">Password</form:label>
		    <form:errors path="password"/>
		    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"></form:input>
		  </div>
		  <input style="margin-top:10px" type="submit" class="btn btn-danger" value="Log In">
		</form:form>
</div>
</body>
</html>