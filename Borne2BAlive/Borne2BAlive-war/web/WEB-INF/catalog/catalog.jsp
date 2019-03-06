

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="style/catalog.css">
        <title>Borne2BAlive - Catalogue</title>
    </head>
    <body>
        
        <c:url var="pageHead" value="MainController?section=catalog&zone=pageHead" />
        <c:import url="${pageHead}" />
        
        <c:url var="navBar" value="MainController?section=catalog&zone=navBar" />
        <c:import url="${navBar}" />
        
        <c:url var="mainDisplay" value="MainController?section=catalog&zone=mainDisplay" />
        <c:import url="${mainDisplay}" />
        
        <c:url var="cart" value="MainController?section=catalog&zone=cart" />
        <c:import url="${cart}" />
        
        
        
        
        
    </body>
</html>
