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
        <h5>Choisissez une option pour la boisson</h5>
    </div>
</div> 


            

            <div class="row centerStage">

                <c:url var="remove" value="#" />

                <div class="col-md-2 "></div>

                <div class="col-md-2 "><img src="${currentItemDrink.product.img}" alt="${currentItemDrink.product.name}" height="300"></div>
                <div class="col-md-3 "></div>
                <div class="col-md-3"> 
                    <br>
                    <br>
                    <br>
                  
                    <c:forEach var="o" items="${currentDrinkOptions}">

                        <c:url var="option" value="MainController?section=composeMenu&step=7&size=" />
                        <a href="${option}${o.id}" class="btn btn-primary"> ${o.name} : 
                            +<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${o.price * (100 + order.appliedVAT) /100}" /> &euro;
                        </a>
                        <br><br>
                    </c:forEach>
                </div>


                <div class="col-md-2 "></div>

            </div>



            <br><br>

            <div class="row pageFoot" >
    <c:url var="back" value="MainController?section=composeMenu&step=6" />
    <div class="col-md-2"><a href="${back}" class="btn btn-outline-info" role="button" >Retour</a> </div>
    <div class="col-md-2"><a href="#" class="btn btn-outline-danger" role="button" data-toggle="modal" data-target="#cancel">Annuler</a> </div>
    <div class="col-md-6">Total des options :  
        +<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${currentLine.optionPriceApplied * (100 + order.appliedVAT) /100}" /> &euro; </div>
    



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


