<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <title>Document</title>
</head>
<body style="font-family: cursive">
	
		<a style="margin-left: 17%; font-size: 15px"
			href="/projects/Dashboard">Dash board</a>
	
<div class="card text-center" style="width : 550px;margin-left : 28%;margin-top: 5%;border: 2px solid rgb(178, 173, 173);">
        <div class="card-header">
          <h2>Create Project</h2>
        </div>
        <div class="card-body">
	<form:form action="/projects/add" method="post"
		modelAttribute="project" style="width : 400px;margin-left : 15%;">
		<div class="form-group">
			<form:label path="title">Title : </form:label>
			<form:errors path="title" />
			<form:input path="title" type="text" class="form-control"
				aria-describedby="emailHelp"></form:input>
		</div>
		<div class="form-group">
			<form:label path="description">Description: </form:label>
			<form:errors path="description" />
			<form:textarea path="description" class="form-control"></form:textarea>
		</div>
		<div class="form-group">
			<form:label path="dueDate">Due Date:</form:label>
			<form:errors path="dueDate" />
			<form:input path="dueDate" type="date" class="form-control"></form:input>
		</div>
		<div class="form-group">
		<form:label path="category">Category:</form:label>
			<form:select path="category" class="form-control">
				<c:forEach var="category" items="${categories}">
					<form:option value="${category }">${category.name}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<div class="form-group">
<form:label path="language"> Language:</form:label>
			<form:select path="language" class="form-control">
				<c:forEach var="language" items="${languages}">
					<form:option value="${language }">${language.name}</form:option>
				</c:forEach>
			</form:select>
		</div>
		<form:input type="hidden" path="owner" value="${ownerId}" />


		<input style="margin-top: 10px" type="submit" class="btn btn-primary" value="Create">
		            <p><a style="margin-top: 5%; font-size: 15px" class="btn btn-danger"  href="/projects/Dashboard">Dashboard</a></p> 
		
	</form:form>
      </div>
      </div>  
       
    
</body>
</html>