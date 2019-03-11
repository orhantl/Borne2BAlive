<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Votre commande</h1>
        <c:forEach var="l" items="${lines}">
            
            <p>${l.product.name} ${l.qty} ${l.preTaxPrice}</p>
        
        </c:forEach>
        
        <br>
        Prix hors taxe :
        <br>
        Tva Appliquée : ${order.appliedVAT}
        <br>
        Prix toutes taxes comprises :
        <br>
        <br>
        
        
        <a href="MainController?section=cart&order=${order}">Modifier</a>
        <br>
        <a href="#">Abandonner</a>
        <br>
        <a href="#">Confirmer</a>
        <br>
        
    </body>
</html>
