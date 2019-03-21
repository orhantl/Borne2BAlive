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
        <link rel="stylesheet" href="style/welcomScreeConsumChoice.css">



    </head>
    <body>

        <div id="demo" class="carousel slide textWelcome" data-ride="carousel" >
            <ul class="carousel-indicators">
            </ul>
            <div class="carousel-inner">
                <div class="carousel-item active">  
                    <img src="Img/WelcomeScreenPict/restaurant.jpg" alt="WelcResto" width="1500" height="650">
                    <div class="carousel-caption textWelcome">
                        <h3>Borne2BAlive</h3>
                        <p>Vous souhaite la bienvenue</p>
                    </div>   
                </div>
                <div class="carousel-item">
                    <img src="Img/WelcomeScreenPict/menuAdana.jpg" alt="offMom1" width="1500" height="650">
                    <div class="carousel-caption textWelcome">
                        <h3>A l'honneur en ce moment</h3>
                    </div>   
                </div>
                <div class="carousel-item">
                    <img src="Img/WelcomeScreenPict/menuKoft.jpg" alt="offMom2" width="1500" height="650">
                    <div class="carousel-caption textWelcome">
                        <h3>À ne pas rater !</h3>
                    </div>   
                </div>
                <div class="carousel-item">
                    <img src="Img/WelcomeScreenPict/menuAmerican2.jpg" alt="New York" width="1500" height="650">
                    <div class="carousel-caption textWelcome">
                        <br>
                        <br>
                        <h3>Prochainement</h3>
                    </div>   
                </div>
            </div>

        </div>

        <a href="MainController?section=consumChoice" style="text-decoration: none;" >
            <div class= "bigButton" style="text-decoration: none;">
                COMMANDER
            </div>
        </a>

        <script src="Ajax/getAjax.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        
    </body>
</html>