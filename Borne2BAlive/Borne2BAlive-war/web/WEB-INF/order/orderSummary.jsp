<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style/orderStyle.css">
        <link rel="stylesheet" href="style/catalog.css">
        <title>Récapitulatif de la commande</title>

    </head>
    <body>


        <c:url var="pageHead" value="MainController?section=catalog&zone=pageHead" />
        <c:import url="${pageHead}" />

        <div class="globalContent">

            <div class="pageHead">
                <div class="col-md-12">
                    <h1>Votre commande</h1>
                </div>
            </div>

            <div class="mainContent">
                <div class="col-md-2 "></div>
                <div class="col-md-8 leftPadding rightPadding">
                    <table class="table table-bordered">
                        <thead>
                            <tr align="center">
                                <th>Article</th>
                                <th>Quantité</th>
                                <th>Prix HT</th>
                            </tr>

                        </thead>

                        <tbody>

                            <c:forEach var="l" items="${lines}">

                                <tr>
                                    <td>${l.menu.name} ${l.product.name}</td>
                                    <td>${l.qty}</td>
                                    <td>${l.preTaxPrice}</td>
                                </tr>
                            </c:forEach>

                        </tbody>    
                    </table>
                    <br>
                    <table class="table table-bordered">
                        <tbody>
                            <tr>
                                <th>Prix hors taxe :</th>
                                <td>${preTaxPrice} €</td>
                            </tr>
                            <tr>
                                <th>Tva appliquée :</th>
                                <td>${order.appliedVAT} %</td>
                            </tr>
                            <tr>
                                <th>Prix toutes taxes comprises :</th>
                                <td><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${priceVAT}" /> €</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-2 "></div>
            </div>

            <div class="orderFooter">
                <a href="MainController?section=cart&order=${order}">Modifier</a>
                
                <a href="MainController?section=kill" class="btn btn-outline-danger">Abandonner</a>
                
                <a href="MainController?section=orderCheckOut&order=${order}&priceVAT=${priceVAT}&preTaxPrice=${preTaxPrice}">Confirmer</a>                
            </div>

        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script type="text/javascript" src="style/idleTimer.js"></script>


    </body>
</html>
