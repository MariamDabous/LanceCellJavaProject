<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<title>Owner Dashboard</title>
</head>
<body>
	<header class="container">
		<h1 class="text-center text-primary">Welcome!</h1>
		<a href="programmers">Got the code? Register and Login Here</a>
	</header>
	<main class="col" style="width:800px;margin-left:20%">
		<div class="row border mx-5 my-5">
			<div class="mb-3">
				<h2>Register</h2>
			</div>
			<form:form action="/owners/register" method="post" modelAttribute="newOwner">
				<div class="mb-3">
					<form:label path="firstName" class="form-label">First Name:</form:label>
					<div>
						<form:errors path="firstName" class="text-danger small"></form:errors>
					</div>
					<form:input path="firstName" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="lastName" class="form-label">Last Name:</form:label>
					<div>
						<form:errors path="lastName" class="text-danger small"></form:errors>
					</div>
					<form:input path="lastName" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="email" class="form-label">Email:</form:label>
					<div>
						<form:errors path="email" class="text-danger small"></form:errors>
					</div>
					<form:input path="email" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="phoneNumber" class="form-label">Phone Number:</form:label>
					<div>
						<form:errors path="phoneNumber" class="text-danger small"></form:errors>
					</div>
					<form:input path="phoneNumber" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="password" class="form-label">Password:</form:label>
					<div>
						<form:errors path="password" class="text-danger small"></form:errors>
					</div>
					<form:input type="password" path="password" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="confirm" class="form-label">Password Confirmation:</form:label>
					<div>
						<form:errors path="confirm" class="text-danger small"></form:errors>
					</div>
					<form:input type="password" path="confirm" class="form-control" />
				</div>
				<input class="btn btn-primary my-3" type="submit" value="Register" />
			</form:form>
		</div>
		<div class="row border mx-5">
			<form:form action="/owners/login" method="post" modelAttribute="newLogin">
				<div class="mb-3">
				<h2>Login</h2>
				</div>
				<div class="mb-3">
					<form:label path="email" class="form-label">Email:</form:label>
					<div>
						<form:errors path="email" class="text-danger small"></form:errors>
					</div>
					<form:input path="email" class="form-control" />
				</div>
				<div class="mb-3">
					<form:label path="password" class="form-label">Password:</form:label>
					<div>
						<form:errors path="password" class="text-danger small"></form:errors>
					</div>
					<form:input type="password" path="password" class="form-control" />
				</div>
				<input class="btn btn-primary my-3" type="submit" value="Login" />
			</form:form>
		</div>
	</main>
</body>
</html>