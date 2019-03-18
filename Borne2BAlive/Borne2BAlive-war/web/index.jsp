<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <a href="MainController?section=create">creer les données</a>
        <hr>
        <%--<a href="MainController?section=orderSummary">Passez votre commande</a>--%>           
        <hr>
        <a href="MainController?section=catalog">Afficher le catalogue</a>
        <hr>
        <a href="MainController?section=welcomeScreen">Afficher welcomeScreen</a>
        
        
        <hr>
        
        
    </body>
</html>
