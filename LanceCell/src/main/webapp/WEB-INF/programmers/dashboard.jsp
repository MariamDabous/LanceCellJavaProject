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
<meta charset="UTF-8">
<title>Programmer Dashboard</title>
</head>
<body>
	<h1>Welcome ${thisProg.firstName } ${thisProg.lastName}</h1>
	<h3>
		<a href="/programmers/Profile/${thisProg.id}">My Profile</a>
	</h3>
	<h2>Choose a language</h2>
	<form action="/programmers/search">
		<select name="language">
			<c:forEach var="language" items="${languages}">
				<option value="${language }">${language.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Search"/>
	</form>
	<h2>All Projects :</h2>
	<table>
		<thead>
			<tr>
				<th>Project Name</th>
				<th>Owner</th>
				<th>Team</th>
				<th>Actions</th>
			</tr>
		</thead>


		<c:forEach var="thisProject" items="${AllProjects}">
			<tr>
				<td><a href="/programmers/show/${thisProject.id}">${thisProject.title}</a></td>
				<td>${thisProject.owner.firstName}${thisProject.owner.lastName}</td>

				<td><a href="/projects/showTeam/${thisProject.id}">Show
						Team</a></td>
				<td><c:choose>
						<c:when test="${thisProject.getRequests().contains(thisProg)}">
							<td>You Sent a request</td>
						</c:when>
						<c:otherwise>
							<c:choose>
								<c:when
									test="${thisProject.getProgrammmers().contains(thisProg)}">
									<td>You are in this team</td>
								</c:when>
								<c:otherwise>
									<form:form action="/programmers/joinRequest/${thisProject.id}"
										method="post">
										<input type="submit" value="Join Team" />
									</form:form>
								</c:otherwise>
							</c:choose>
						</c:otherwise>
					</c:choose></td>



			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<h2>My Project:</h2>
	<table>
		<thead>
			<tr>
				<th>Project Name</th>
				<th>Owner</th>
				<th>Team</th>
			</tr>
		</thead>
		<c:choose>
		<c:when test="${thisProg.project != null}">
		<tr>
		
			<td><a href="/projects/show/${thisProg.project.id}">${proj.title}</a></td>
			<td>${thisProg.project.owner.firstName}
				${thisProg.project.owner.lastName}</td>
			<td><a href="/projects/showTeam/${thisProg.project.id}">ShowTeam</a></td>
		</tr>
		</c:when>
		<c:otherwise><tr></tr></c:otherwise>
		</c:choose>
	</table>

	<h2>My Requests:</h2>
	<table>
		<thead>
			<tr>
				<th>Project Name</th>
				<th>Owner</th>
				<th>Team</th>
			</tr>
		</thead>
		<c:forEach var="request" items="${sentRequests}">
			<tr>
				<td><a href="/programmers/show/${request.id}">${request.title}</a></td>
				<td>${request.owner.firstName}${request.owner.lastName}</td>
				<td><form:form
						action="/programmers/deleteRequest/${request.id}" method="delete">
						<input type="submit" value="Leave" />
					</form:form></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>