<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style/catalog.css">
        <link rel="stylesheet" href="style/composeMenuStyle.css">
        <title>Borne2BAlive</title>
    </head>
    <body>
        <c:url var="pageHead" value="MainController?section=catalog&zone=pageHead" />
        <c:import url="${pageHead}" />

        <div class="globalContent">
            <c:url var="zoneHead" value="MainController?section=composeMenu&step=4&zone=header" />
            <c:import url="${zoneHead}" />

            <div class="row centerStage">

                <c:url var="remove" value="#" />

                <div class="col-md-3 "></div>

                <div class="col-md-2 "><img src="${currentItemSide.product.img}" alt="${currentItemSide.product.name}" height="300"></div>
                <div class="col-md-1 "></div>
                <div class="col-md-3"> 
                    <c:forEach var="o" items="${currentSideOptions}">

                        <c:url var="option" value="MainController?section=composeMenu&step=4&option=${o.id}" />
                        <a href="${option}" class="btn btn-outline-primary"> ${o.name} : 
                            +<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${o.price * (100 + currentOrder.appliedVAT) /100}" /> &euro;
                        </a>
                        <br><br>
                    </c:forEach>
                </div>


                <div class="col-md-3 "></div>

            </div>



            <br><br>

            <c:url var="pageFoot" value="MainController?section=composeMenu&step=4&zone=footer" />
            <c:import url="${pageFoot}" />

            <br>
        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    </body>
</html>


