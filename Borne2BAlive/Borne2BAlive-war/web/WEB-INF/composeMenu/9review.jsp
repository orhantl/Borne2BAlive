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
            <c:url var="zoneHead" value="MainController?section=composeMenu&step=9&zone=header" />
            <c:import url="${zoneHead}" />







            <div class="row centerStage">




                <div class="col-md-4"></div>
                <div class="col-md-4">

                    <table class="table-borderless table-hover table-striped">
                        <tr>
                            <td width="200">${currentItemSandwich.product.name}</td>
                            <td width="200">
                                <c:forEach var="sandwichOptions" items="${currentItemSandwich.options}">
                                    ${sandwichOptions.name}
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td>${currentItemSide.product.name}</td>
                            <td>
                                <c:forEach var="sideOptions" items="${currentItemSide.options}">
                                    ${sideOptions.name}
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td>${currentItemDrink.product.name}</td>
                            <td>
                                <c:forEach var="drinkOptions" items="${currentItemDrink.options}">
                                    ${drinkOptions.name}
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <td>${currentItemSauce.product.name}</td>
                            <td>
                                <c:forEach var="sauceOptions" items="${currentItemSauce.options}">
                                    ${sauceOptions.name}
                                </c:forEach>
                            </td>
                        </tr>
                    </table>
                </div>

                <div class="col-md-2"></div>
                <div class="col-md-2">
                    <u>Prix</u>
                    <br>Menu : <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${currentLine.preTaxPrice * (100 + currentOrder.appliedVAT) /100}" /> &euro; 
                    <br>Options : <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${currentLine.optionPriceApplied * (100 + currentOrder.appliedVAT) /100}" /> &euro; 
                    <br>Total : <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${(currentLine.optionPriceApplied * (100 + currentOrder.appliedVAT) /100) + (currentLine.preTaxPrice * (100 + currentOrder.appliedVAT) /100)}" /> &euro;
                </div>
            </div>


             <br><br>

            <c:url var="pageFoot" value="MainController?section=composeMenu&step=9&zone=footer" />
            <c:import url="${pageFoot}" />

            <br>
        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    </body>
</html>


