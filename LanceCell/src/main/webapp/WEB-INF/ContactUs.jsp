<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LanceCell ContactUs</title>
 <link rel="stylesheet" href="css/bootstrap.min.css">
 <link rel="stylesheet" href="css/style.css">
<style>
        * {
            margin: 0;
            padding: 0;
           
        }
        body{
          	background-image: url("css/us.jpg");
          	 background-repeat: no-repeat, repeat;
            background-size: cover;
          	opacity: 12;
	   		height : 600px ;

        }
               
        h2{
            font-size: 50px;
            margin-bottom: 5%;
            background-color:rgb(137 137 137);
            color: white;
            text-align: center;
        }
        a{
            color: white;
           
        }
        td{
            width: 10%;
        }
        header{
        display: flex;
        justify-content: space-evenly;
        font-family:"tenso","tenso_latinextreme","Helvetica","Arial",sans-serif;
    
        }
    
    td {
        padding-bottom: 2rem;
        font-size: large;
        color: white;
        background-color:gray;
        padding : 3% ;
        border : 1px solid white ;
    }
    th{
    font-weight: bold;
    color: black;

    }
    table {
    border-collapse: collapse;
    width: 50%;
    color: black;
    margin : 0 auto ;
  
    
    }
    .logos{
    width:15%;
    }


    </style>
</head>

<body>
<nav class="navb">
<h1 class="Lance"><a href="/" style=" text-decoration: none; color:white;"> <span class="l">L</span>anceCell</a></h1>
<div class="tabs">
<a class="anch" href="#">Login/Register</a>
</div>
</nav>
    <div class="main">
        <div  class="container">
            <br><br><br><br><br>
            <h2 style="background-color:gray">Contact Us</h2>
            <table class="table">
                <tr >
                    <td scope="col">Email:</td>
                    <td scope="col">LanceCell@gmail.com</td>
                </tr>
                <tr >
                    <td scope="col">Phone Number :</td>
                    <td scope="col">+970595281307</td>
                </tr>
                <tr >
                    <td scope="col">Social Media</td>
                    <td scope="col">
                        <a href="https://www.instagram.com/"><svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-brand-instagram" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                            <rect x="4" y="4" width="16" height="16" rx="4"></rect>
                            <circle cx="12" cy="12" r="3"></circle>
                            <line x1="16.5" y1="7.5" x2="16.5" y2="7.501"></line>
                         </svg></a>
                        <a href="https://www.facebook.com/"><svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-brand-facebook" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                            <path d="M7 10v4h3v7h4v-7h3l1 -4h-4v-2a1 1 0 0 1 1 -1h3v-4h-3a5 5 0 0 0 -5 5v2h-3"></path>
                         </svg></a>
                        <a href="https://twitter.com/"><svg xmlns="http://www.w3.org/2000/svg" class="icon icon-tabler icon-tabler-brand-twitter" width="24" height="24" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round">
                            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                            <path d="M22 4.01c-1 .49 -1.98 .689 -3 .99c-1.121 -1.265 -2.783 -1.335 -4.38 -.737s-2.643 2.06 -2.62 3.737v1c-3.245 .083 -6.135 -1.395 -8 -4c0 0 -4.182 7.433 4 11c-1.872 1.247 -3.739 2.088 -6 2c3.308 1.803 6.913 2.423 10.034 1.517c3.58 -1.04 6.522 -3.723 7.651 -7.742a13.84 13.84 0 0 0 .497 -3.753c-.002 -.249 1.51 -2.772 1.818 -4.013z"></path>
                         </svg></a>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</body>
</html>