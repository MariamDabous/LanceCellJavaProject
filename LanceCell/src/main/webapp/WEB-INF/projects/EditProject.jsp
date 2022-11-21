<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
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
<title>Edit Project</title>
</head>
<body>
<<<<<<< HEAD
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

   <!-- Project Category -->
   <div class="form-group">
             <form:select path="category">
             <form:options items="${project.category}"/>
           </form:select>
    </div>

    <!-- Project Language -->
       <div class="form-group">
             <form:select path="languages">
             <form:options items="${project.languages}"/>
           </form:select>
    </div>


            <input style="margin-top:10px" type="submit" class="btn btn-danger" value="Create">
    </form:form>
=======

>>>>>>> ab91a42a3b0798224356302c748546461f3d7342
</body>
</html>