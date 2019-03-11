<%-- 
    Document   : welcomeCatalog
    Created on : 6 mars 2019, 13:05:40
    Author     : cdi115
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap welcomeScreen</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <style>
  /* Make the image fully responsive 
  .carousel-inner img {
    width: 100%;
    height: 100%; 
  }*/
  </style>
</head>
<body>

<div id="demo" class="carousel slide" data-ride="carousel" >
  <ul class="carousel-indicators">
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">  
      <img src="Img/WelcomeScreenPict/restaurant.jpg" alt="WelcResto" width="1500" height="700">
      <div class="carousel-caption">
        <h3>Borne2BAlive</h3>
        <p>Vous souhaite la bienvenue...!!!</p>
      </div>   
    </div>
    <div class="carousel-item">
        <img src="Img/WelcomeScreenPict/menuAdana.jpg" alt="offMom1" width="1500" height="700">
      <div class="carousel-caption">
        <h3>Offre du moment</h3>
        <p>A ne pas rater...!!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="Img/WelcomeScreenPict/menuKoft.jpg" alt="offMom2" width="1500" height="700">
      <div class="carousel-caption">
        <h3>Offre du moment</h3>
        <p>A ne pas rater!!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="Img/WelcomeScreenPict/menuAmerican.jpg" alt="New York" width="1500" height="700">
      <div class="carousel-caption">
           <br>
          <br>
        <h3>We love America</h3>
        <p>We love the Big Hamburger!...!</p>
      </div>   
    </div>
  </div>
 
</div>
    
    <div class="jumbotron text-center" >     
  <a href="WEB-INF/consumerChoice/consumChoice.jsp" class="btn btn-outline-dark">Commander</a>
</div>
  
</body>
</html>
