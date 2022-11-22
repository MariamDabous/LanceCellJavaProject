<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Project</title>
</head>
<body>

<form:form action="/projects/edit/${project.id}" method="post" modelAttribute="project"  style="width : 400px;margin-left : 15%;">
      <form:hidden path="owner" value="${owner_id}"/>
      <div class="form-group">
        <form:label path="title" >Title : </form:label>
        <form:errors path="title"/>
        <form:input path="title" type="text" class="form-control"  aria-describedby="emailHelp" ></form:input>
      </div>
      <div class="form-group">
        <form:label path="description" >Skill Level(1-5): </form:label>
        <form:errors path="description"/>
        <form:input path= "description" type="text" class="form-control"  ></form:input>
      </div>
      <div class="form-group">
        <form:label path="dueDate" >Due Date:</form:label>
        <form:errors path="dueDate"/>
        <form:input path="dueDate"  type="date" class="form-control" ></form:input>
      </div>

   <div class="form-group">
		
			<form:select path="category">
				<c:forEach var="category" items="${categories}">
				<form:option value="${category }">${category.name}</form:option>
				</c:forEach>
			</form:select>
		</div>

  


            <input style="margin-top:10px" type="submit" class="btn btn-danger" value="Update">
    </form:form>

</body>
</html>