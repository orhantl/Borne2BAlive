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
       Nos menus :

        <div class="card-columns">

            <c:forEach var="m" items="${MENUS}">

                <div class="card" style="width:200px">
                    <img class="card-img-top" src="${m.img}" alt="">
                    <div class="card-body">
                        <h5 class="card-title">${m.name}</h4>
                        <p class="card-text">${m.description}</p>
                        <a href="#" class="btn btn-primary stretched-link">Sélectionner</a>
                    </div>
                </div>

            </c:forEach>

        </div>

    </body>
</html>