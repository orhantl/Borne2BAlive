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
            <div class="row pageHead">
                <div class="col-md-12">
                    <h6>${currentLine.menu.name}</h6>
                    <h5>Vérifiez votre menu</h5>
                </div>
            </div> 








            <div class="row centerStage">




                <div class="col-md-2"></div>
                <div class="col-md-6">

                    <table class="table-borderless table-hover">
                        <tr height="70">
                            <td width="200" class="reviewProductText">${currentItemSandwich.product.name}</td>
                            <td width="400">- 
                                <c:forEach var="sandwichOptions" items="${currentItemSandwich.options}">
                                    ${sandwichOptions.name} - 
                                </c:forEach>
                            </td>
                            <c:url var="modifySandwich" value="MainController?section=composeMenu&step=2" />
                            <td width="200"><a href="${modifySandwich}" class="btn btn-outline-info">Modifier</a></td>
                        </tr>
                        <tr height="70">
                            <td class="reviewProductText">${currentItemSide.product.name}</td>
                            <td>-
                                <c:forEach var="sideOptions" items="${currentItemSide.options}">
                                    ${sideOptions.name} - 
                                </c:forEach>
                            </td>
                            <c:url var="modifySide" value="MainController?section=composeMenu&step=3" />
                            <td><a href="${modifySide}" class="btn btn-outline-info">Modifier</a></td>
                        </tr>
                        <tr height="70">
                            <td class="reviewProductText">${currentItemDrink.product.name}</td>
                            <td>-
                                <c:forEach var="drinkOptions" items="${currentItemDrink.options}">
                                    ${drinkOptions.name} - 
                                </c:forEach>
                            </td>
                            <c:url var="modifyDrink" value="MainController?section=composeMenu&step=6" />
                            <td><a href="${modifyDrink}" class="btn btn-outline-info">Modifier</a></td>
                        </tr>
                        <tr height="70">
                            <td class="reviewProductText">${currentItemSauce.product.name}</td>
                            <td>-
                                <c:forEach var="sauceOptions" items="${currentItemSauce.options}">
                                    ${sauceOptions.name} - 
                                </c:forEach>
                            </td>
                            <c:url var="modifySauce" value="MainController?section=composeMenu&step=5" />
                            <td><a href="${modifySauce}" class="btn btn-outline-info">Modifier</a></td>
                        </tr>
                    </table>
                </div>

                <div class="col-md-1"></div>
                <div class="col-md-2">
                    
                    <table class="table table-success">
                        <tr>
                            <th></th>
                            <th>Prix</th>
                        </tr>
                        <tr><td>Menu</td>
                            <td> <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${currentLine.getProductFullPrice(order.getAppliedVAT())}" /> &euro; 
                            </td></tr>
                        <tr><td>Options</td>
                            <td> <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${currentLine.getOptionsFullPrice(order.getAppliedVAT())}" /> &euro; 
                            </td></tr>
                        <tr><td>Total</td>
                            <td> <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${currentLine.getFullPrice(order.getAppliedVAT())}" /> &euro;
                            </td></tr>
                    </table>


                </div>
                <div class="col-md-1"></div>
            </div>


            <br><br>

            <div class="row pageFoot" >
                <div class="col-md-2"></div>
                <div class="col-md-2"><a href="#" class="btn btn-outline-danger" role="button" data-toggle="modal" data-target="#cancel">Annuler</a> </div>
                <div class="col-md-6"></div>
                <c:url var="addToCart" value="MainController?section=composeMenu&step=9&add" />
                <div class="col-md-2"><a href="${addToCart}" class="btn btn-success" role="button" >Ajouter au panier</a> </div>



                <!-- Modal -->
                <div class="modal fade" id="cancel" role="dialog">
                    <div class="modal-dialog modal-md modal-dialog-centered">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Attention !</h4>
                            </div>
                            <div class="modal-body">
                                <p>Vous êtes sur le point de supprimer vos modifications. </p>
                                <p>Appuyez sur "Retour" si vous souhaitez finaliser votre menu. </p>
                                <p>Appuyez sur "Confirmer" si vous souhaitez revenir à l'écran d'accueil</p>
                            </div>
                            <div class="modal-footer">
                                <a href="#" class="btn btn-info" data-dismiss="modal">Retour</a>
                                <a href="MainController?section=composeMenu&step=kill" class="btn btn-danger">Confirmer</a>
                            </div>
                        </div>
                    </div>
                </div>




            </div> 


            <br>
        </div>



        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


    </body>
</html>


