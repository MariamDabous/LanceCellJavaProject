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
<h3><a href="/programmers/Profile/${thisProg.id}">My Profile</a></h3>
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
<td><a href="/programmers/show/${thisProject.id}">${thisProject.title}</a></td>
<td>${thisProject.owner.firstName}${thisProject.owner.lastName}</td>

<td><a href="/programmers/showTeam/${thisProject.id}">Show Team</a></td>
<td>
<form:form action="/programmers/joinRequest/${thisProject.id}" method="post">
<input type="submit" value="Join Team"/>
</form:form></td>



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
<c:forEach var="thisProgProject" items="${sentRequests}">
<tr>
<td><a href="/projects/show/${thisProgProject.id}">${thisProgProject.title}</a></td>
<td>${thisProgProject.owner.firstName}${thisProgProject.owner.lastName}</td>
<td><a href="/projects/showTeam/${thisProgProject.id}"></a></td>
</tr>
</c:forEach>
</table>

<h2>My Requests: </h2>
<table>
<thead>
<tr>
<th>Project Name </th>
<th>Owner</th>
<th>Team</th>
</tr>
</thead>
<c:forEach var="request" items="${sentRequests}">
<tr>
<td><a href="/projects/show/${request.id}">${request.title}</a></td>
<td>${request.owner.firstName}${request.owner.lastName}</td>
<td>
<form:form action="/programmers/deleteRequest/${request.id}" method="delete">
<input type="submit" value="Leave"/>
</form:form>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>