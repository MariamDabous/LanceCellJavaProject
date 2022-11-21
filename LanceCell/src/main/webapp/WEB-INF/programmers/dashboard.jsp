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
<title>Programmer Dashboard</title>
</head>
<body>
<h1>Welcome ${thisProg.firstName } ${thisProg.lastName}</h1>
<h2>Choose a language</h2>

<h2>All Projects : </h2>
<table>
<thead>
<tr>
<th>Project Name </th>
<th>Owner</th>
<th>Team</th>
<th>Actions</th>
</tr>
</thead>


<c:forEach var="thisProject" items="${AllProjects}">
<tr>
<td><a href="/projects/show/${thisProject.id}">${thisProject.title}</a></td>
<td>${thisProject.owner.firstName}${thisProject.owner.lastName}</td>
<td><a href="/projects/showTeam/${thisProject.id}">Show Team</a></td>
<td><a href="/projects/joinRequest/${thisProject.id}">Request to join</a></td>

</tr>
</c:forEach>
</table>
<br><br>
<h2>My Project: </h2>
<table>
<thead>
<tr>
<th>Project Name </th>
<th>Owner</th>
<th>Team</th>
</tr>
</thead>
<c:forEach var="thisProgProject" items="${thisProgProject}">
<tr>
<td><a href="/projects/show/${thisProgProject.id}">${thisProgProject.title}</a></td>
<td>${thisProgProject.Owner.firstName}${thisProgProject.Owner.lastName}</td>
<td><a href="/projects/showTeam/${thisProgProject.id}">Show Team</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>