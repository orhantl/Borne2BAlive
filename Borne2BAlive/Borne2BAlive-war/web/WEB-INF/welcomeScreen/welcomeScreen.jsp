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
    height: 100%;    r
  }*/
  </style>
</head>
<body>

<div id="demo" class="carousel slide" data-ride="carousel" >
  <ul class="carousel-indicators">
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">  
      <img src="Img/WelcomeScreenPict/restaurant.jpg" alt="WelcResto" width="1500" height="600">
      <div class="carousel-caption">
        <h3>Borne2BAlive</h3>
        <p>Vous souhaite la bienvenue...!!!</p>
      </div>   
    </div>
    <div class="carousel-item">
        <img src="Img/WelcomeScreenPict/menuAdana.jpg" alt="offMom1" width="1500" height="600">
      <div class="carousel-caption">
        <h3>Offre du moment</h3>
        <p>À ne pas rater...!!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="Img/WelcomeScreenPict/menuKoft.jpg" alt="offMom2" width="1500" height="600">
      <div class="carousel-caption">
        <h3>Offre du moment</h3>
        <p>À ne pas rater!!</p>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="Img/WelcomeScreenPict/menuAmerican2.jpg" alt="New York" width="1500" height="600">
      <div class="carousel-caption">
           <br>
          <br>
        <h3>We love America</h3>
        <p>We love the Big Hamburger!...!</p>
      </div>   
    </div>
  </div>
 
</div>
    

    <style>
.footer {
  position: fixed;
  left: 0;
  bottom: auto;
  width: 100%;
  background-color: black;
  color: white;
 text-align: center;
  height: 30%; 
  margin-bottom:0;
  padding: 30px;

 }
  .btn-lg{
  
      text-align: center;
      width:100%;
       height:400px;
 
}
</style>

        
<div class="footer">
    <a href="MainController?section=consumChoice" class="btn btn-outline-dark btn-lg btn-block">Commander</a>

    
    <%-- <li class="nav-item">
        <c:url value="ControleurMain?section=catalogue" var="url155" />
      <a class="nav-link" href="${url155}">Catalogue</a>
    </li>
    --%>

     
</div>

</body>
</html>
