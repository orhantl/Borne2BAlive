<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />
        <link rel="stylesheet" href="style/composeMenuStyle.css" />
        <title>Composez votre menu</title>
    </head>
    <body>

        <div class="mainFrame">

            <c:url var="pageHead" value="MainController?section=composeMenu&zone=header" />
            <c:import url="${pageHead}" />
            
            <div class="row mainFrameDisplay">
                <div class="col">

                    <img src="${currentSandwich.img}" alt="${currentSandwich.name}" width="300" class="imgSandwich"><br>
                    <a href="#">(retirer des ingrédients)</a>
                    

                </div>
            </div> 
                        
            <c:url var="pageFoot" value="MainController?section=composeMenu&zone=footer" />
            <c:import url="${pageFoot}" />

        </div>

    </body>
</html>
