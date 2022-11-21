<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Github Repositories - REST API</title>
  <!-- bootstrap 4 css -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <!-- google font -->
  <link href="https://fonts.googleapis.com/css?family=Public+Sans:300,500&display=swap" rel="stylesheet">
  <!-- custom css -->
  <link rel="stylesheet" href="css/main.css">
</head>

<body>
  <div class="container-fluid mt-3">
    <!-- jumbotron -->
    <div class="jumbotron jumbotron-fluid bg-info text-white">
      <div class="container-fluid">
        <h1 class="display-5">Github Repositories</h1>
        <p class="lead">using HTML5, CSS3, Bootstrap 4, Jquery, REST API and Postman.</p>
      </div>
    </div>
    <!-- responsive table -->
    <div class="table-responsive">
      <table class="table table-bordered">
        <thead>
          <tr class="table-info">
            <th scope="col">ID</th>
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
    request.open('GET', 'https://api.github.com/users/${test}/repos', true)
    
    request.onload = function () {
      // Begin accessing JSON data here
      var data = JSON.parse(this.response);
      console.log(data);
    
      var statusHTML = '';
      $.each(data, function(i, status) {
        statusHTML += '<tr>';
        statusHTML += '<td>' + status.id + '</td>';
        statusHTML += '<td>' + status.name + '</td>';
        statusHTML += '<td>' + status.html_url + '</td>';
        statusHTML += '<td>' + status.language + '</td>';
        statusHTML += '</tr>';
      });
      $('tbody').html(statusHTML);
    }
    
    // Send request
    request.send();</script>
</body>

</html>