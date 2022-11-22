<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome Page</title>
</head>
<body>
    <h1>Welcome Admin <c:out value="${currentUser.username}"></c:out></h1>
    
    <form id="logoutForm" method="POST" action="/admin/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
    <table>
<thead>
<tr>
<th>Programmer Name </th>
<th>Profile</th>
<th>Actions</th>
</tr>
</thead>


<c:forEach var="Prog" items="${AllRequests}">
<c:choose>
<c:when test="${Prog.isApproved == false}">
<tr>

<td><a href="/admin/Profile/${Prog.id}">${Prog.firstName}${Prog.lastName}</a></td>
<td><a href="/admin/Profile/${Prog.id}">Show Profile</a></td>
<td><a href="/admin/accept/${Prog.id}">Accept</a> | <a href="/admin/reject/${Prog.id}">Reject</a></td>


</tr>
</c:when>
<c:otherwise></c:otherwise>
</c:choose>
</c:forEach>
</table>
</body>
</html>