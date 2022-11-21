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
</head>
<body>
<h1>Welcome ${thisOwner.firstName } ${thisOwner.lastName}</h1>
<a href="/owners/logout">Logout</a>

<h2>My Projects : </h2>
<table>
<thead>
<tr>
<th>Project Name </th>
<th>Team</th>
<th>Actions</th>
</tr>
</thead>


<c:forEach var="thisProject" items="${AllProjects}">
<tr>
<td><a href="/projects/show/${thisProject.id}">${thisProject.title}</a></td>
<td><a href="/projects/showTeam/${thisProject.id}">Show Team</a></td>
<td><a href="/projects/edit/${thisProject.id}">Edit</a> | <a href="/projects/delete/${thisProject.id}">Delete</a></td>

</tr>
</c:forEach>
</table>
<br><br>
<a href="/projects/add">Add Project</a>
<form action="projects/requests/${thisOwner.id}">
<input type="submit" value="Requests">
</form>
</body>
</html>