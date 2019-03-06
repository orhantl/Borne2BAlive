<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <c:forEach var="m" items="${MenusAvailable}">
                <div class="card" style="width:200px; text-align: center;">
                    <img class="card-img-top" src="${m.img}" alt="">
                    <div class="card-body">
                        <h5 class="card-title">${m.name}</h4>
                        <c:set var="VAT" value="${VAT}" />
                        <c:set var="preTaxPrice" value="${m.price}" />
                        <p class="card-text">
                            <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${preTaxPrice * (100 + VAT) /100}" /> &euro;
                        </p>
                        <c:url var="composeMenu" value="MainController?section=composeMenu&selectedMenu=${m.id}" />
                        <a href="${composeMenu}" class="btn btn-primary stretched-link">Sélectionner</a>
                    </div>
                </div>
            </c:forEach>
        </div>

        
       <c:forEach var="u" items="${MenusUnavailable}">
           ${u.name} : Indisponible, bientôt de retour 
       </c:forEach>
    </body>
</html>