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
<title>Insert title here</title>
<link rel="stylesheet" href="css/profilestyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
 <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Public+Sans:300,500&display=swap" rel="stylesheet">
  <link rel="stylesheet" href="css/main.css">
</head>
<body>
	<section class="h-100 gradient-custom-2">
        <div class="container py-5 h-100">
          <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col col-lg-9 col-xl-7">
              <div class="card">
                <div class="rounded-top text-white d-flex flex-row" style="background-color: #bcc1c7; height:200px;">
                  <div class="ms-4 mt-5 d-flex flex-column" style="width: 150px;">
                    <img src="http://ssl.gstatic.com/accounts/ui/avatar_2x.png"
                      alt="Generic placeholder image" class="img-fluid img-thumbnail mt-4 mb-2"
                      style="width: 150px; z-index: 1">
                    <!-- <button type="button" class="btn btn-outline-dark" data-mdb-ripple-color="dark"
                      style="z-index: 1;">
                      Edit profile
                    </button> -->
                  </div>
                  <div class="ms-3" style="margin-top: 130px;">
                    <h5>  ${thisProg.firstName}${thisProg.lastName }</h5>
                  </div>
                </div>
                <div class="p-4 text-black" style="background-color: #f8f9fa;">
       
                </div>
                <div class="card-body p-4 text-black">
                  <div class="mb-5">
                    <p class="lead fw-normal mb-1">About</p>
                    <div class="p-4" style="background-color: #f8f9fa;">
                      <p class="font-italic mb-1">Name : ${thisProg.email}</p>
                      <p class="font-italic mb-1">Phone Number : ${thisProg.phoneNumber }</p>
                      <p class="font-italic mb-1">LinkedIn : <a href="https://www.linkedin.com/in/${thisProg.linkedIn}">${thisProg.linkedIn }</a></p>
                      <p class="font-italic mb-0">GitHub : <a href="https://www.github.com/${thisProg.github}">${thisProg.github}</a></p>
                    </div>
                  </div>

      
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
                        <div class="container-fluid mt-3">
    <!-- jumbotron -->
    <div class="jumbotron jumbotron-fluid bg-info text-white">
      <div class="container-fluid">
        <h1 class="display-5">Github Repositories for ${thisProg.firstName }</h1>
        <p class="lead"></p>
      </div>
    </div>
    <!-- responsive table -->
    <div class="table-responsive">
      <table class="table table-bordered">
        <thead>
          <tr class="table-info">
            <th scope="col">Name</th>
            <th scope="col">URL</th>
            <th scope="col">Language</th>
          </tr>
        </thead>
        <tbody>
          <!-- 
            <tr>
              <td>...</td>
              <td>...</td>
              <td>...</td>
            </tr> 
          -->
        </tbody>
      </table>
    </div>
  </div>
  <!-- jquery cdn  -->
  <script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
  <!-- custom js -->
  <script>// Create a request variable and assign a new XMLHttpRequest object to it.
    var request = new XMLHttpRequest()
    
    // Open a new connection, using the GET request on the URL endpoint
    request.open('GET', 'https://api.github.com/users/${thisProg.github}/repos', true)
    
    request.onload = function () {
      // Begin accessing JSON data here
      var data = JSON.parse(this.response);
      console.log(data);
    
      var statusHTML = '';
      $.each(data, function(i, status) {
        statusHTML += '<tr>';
        statusHTML += '<td>' + status.name + '</td>';
        statusHTML += '<td><a href="' + status.html_url + '">'+ status.html_url +'</td>';
        statusHTML += '<td>' + status.language + '</td>';
        statusHTML += '</tr>';
      });
      $('tbody').html(statusHTML);
    }
    
    // Send request
    request.send();</script>
    

</body>
</html>