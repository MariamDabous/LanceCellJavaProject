<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner Dashboard</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
</head>
<body>
<div style="display:flex;margin-left: 8%;margin-top:4%;margin-right:8%;justify-content:space-between;">
<h1>Welcome ${thisOwner.firstName } ${thisOwner.lastName}</h1>
<a href="/owners/logout">Logout</a>
</div>

<h2 style="margin-left: 8%;margin-top:4%">My Projects : </h2>
<table style="width: 60%;margin-left: 8%;margin-top:4%" class="table table-striped table-bordered ">
	<thead>
		<tr>
			<th>Project Name </th>
			<th>Team</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="thisProject" items="${AllProjects}">
			<tr>
				<td><a href="/projects/show/${thisProject.id}">${thisProject.title}</a></td>
				<td><a href="/projects/showTeam/${thisProject.id}">Show Team</a></td>
				<td><a href="/projects/edit/${thisProject.id}">Edit</a> | <a href="/projects/delete/${thisProject.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br><br>
<a class="btn btn-primary" style="margin-bottom:2%;margin-left: 8%;"href="/projects/add">Add Project</a>
<br>
<a class="btn btn-primary"  style="margin-left: 8%;" href="/projects/requests">Requests</a>
</body>
</html>