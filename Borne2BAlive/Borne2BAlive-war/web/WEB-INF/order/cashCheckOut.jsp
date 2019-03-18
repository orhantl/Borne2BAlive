<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Paiement à la caisse</title>
    </head>
    <body>
        <h1><center>Autres paiements</center></h1>
        <br>
        <br>
        <br>
        <h2><center>Votre commande a bien été prise en compte</center></h2>
        <br>
        <br>
        <h2><center>N° ${queueNumber}</center></h2>
        <br>
        <br>
        <h2><center>Rendez-vous à la caisse n° ${order.cashier.id}</center></h2>
        
        <script type="text/javascript" src="style/endOrder.js"></script>
    </body>
</html>
