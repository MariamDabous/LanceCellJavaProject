<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="programmer" items="${thisProjectTeam}">
<p>${programmer.firstName }${programmer.lastName }</p>
</c:forEach>

</body>
</html>