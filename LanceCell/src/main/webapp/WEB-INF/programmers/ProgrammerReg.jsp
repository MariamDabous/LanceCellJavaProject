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
<title>Insert title here</title>
</head>
<body>
<div style="padding:3%">

<div class="form1" style="margin-left:11%">
	<h3 style="margin-left : 15%;font-weight:bold">Register</h3>
	<form:form action="/registerForProg" method="post" modelAttribute="newProg"  style="width :400px;margin-left: 15%;">
	  <div class="form-group">
	    <form:label path="firstName" for="exampleInputEmail1">First Name : </form:label>
	    <form:errors path="firstName"/>
	    <form:input path="firstName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="First Name"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="lastName" for="exampleInputEmail1">Last Name : </form:label>
	    <form:errors path="lastName"/>
	    <form:input path="lastName" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Last Name"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="phoneNumber" for="exampleInputPassword1">Phone Number : </form:label>
	    <form:errors path="phoneNumber"/>
	    <form:input path= "phoneNumber" type="text" class="form-control" id="exampleInputPassword1" placeholder="Phone Number"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="email" for="exampleInputPassword1">Email : </form:label>
	    <form:errors path="email"/>
	    <form:input path= "email" type="email" class="form-control" id="exampleInputPassword1" placeholder="Email"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="github" for="exampleInputPassword1">GitHub Link : </form:label>
	    <form:errors path="github"/>
	    <form:input path= "github" type="text" class="form-control" id="exampleInputPassword1" placeholder="Email"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="cv" for="exampleInputPassword1">CV: </form:label>
	    <form:errors path="cv"/>
	    <form:input path= "cv" type="file" class="form-control" id="exampleInputPassword1" placeholder="Email"></form:input>
	  </div>
	  <div class="form-group">
	    <form:label path="password" for="exampleInputPassword1">Password:</form:label>
	    <form:errors path="password"/>
	    <form:input path="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"></form:input>
	  </div>
	  
	  <div class="form-group">
	    <form:label path="confirm" for="exampleInputPassword1">Confirm PW :</form:label>
	    <form:errors path="confirm"/>
	    <form:input path="confirm" type="password" class="form-control" id="exampleInputPassword1" placeholder="Confirm Password"></form:input>
	  </div>
	  <input style="margin-top:10px" type="submit" class="btn btn-danger" value="Register">
	</form:form>
</div>
</div>
<a href="">You Have an Account?  Login Here </a>
</body>
</html>