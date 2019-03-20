<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : consumChoice
    Created on : 11 mars 2019, 10:38:28
    Author     : cdi115
--%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
        <link rel="stylesheet" href="style/start.css">
        <title>Borne2BAlive</title>
    </head>


    <body>

        <c:url var="pageHead" value="MainController?section=catalog&zone=pageHead" />
        <c:import url="${pageHead}" />


        <div class="row">
            <div class="title">Où souhaitez-vous déguster votre commande?</div>
        </div>


        <div class="row choice">

            <div class="col-md-3"></div>

            <c:url var="choiceURL" value="MainController?section=consumChoice&locationID=" />
            <c:forEach var="l" items="${locations}">
                <div class="col-md-2">
                    <div class="catSquare">
                        <a href="${choiceURL}${l.id}">
                            <div class="squareText stretched-link">${l.name}</div>
                        </a> 
                    </div>
                </div>
                    <div class="col-md-1"></div>
            </c:forEach>

            <div class="col-md-3"></div>
        </div>



        <script type="text/javascript" src="style/idleTimer.js"></script>

    </body>
</html>
