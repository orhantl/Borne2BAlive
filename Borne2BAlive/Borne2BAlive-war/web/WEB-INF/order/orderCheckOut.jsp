<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choix du paiement</title>
    </head>
    <body>
        <h1>Choix du paiement</h1>
        <br>
        <br>
        <a href="MainController?section=cashCheckOut">Espèces</a>
        <br>
        <a href="MainController?section=cashCheckOut">Tickets restaurant</a>
        <br>
        <a href="MainController?section=creditCardCheckOut">Carte bancaire, paiement sans contact</a>
        <br>
        <br>
        <a href="MainController?section=kill">Abandonner</a>
        <br>
        <a href="MainController?section=orderSummary">Retour</a>
        
    </body>
</html>
