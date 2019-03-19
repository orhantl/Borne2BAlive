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
        <title>Borne2BAlive - Catalogue</title>
    </head>
    <body>
        <c:url var="pageHead" value="MainController?section=catalog&zone=pageHead" />
        <c:import url="${pageHead}" />

        <div class="globalContent">
            <div class="row pageHead">
                <div class="col-md-12">
                    <h6>${currentLine.menu.name}</h6>
                    <h5>Votre sandwich</h5>
                </div>
            </div> 


            <div class="row">
                <div class="col-md-9">

                </div>

                <div class="col contentSandwichImg">
                    <img class="imgSandwich sandwich" src="${currentSandwich.img}" alt="${currentSandwich.name}" height="450" >
                </div>



                <div class="col-md-3 contentSandwichOptions">
                    <div id="infos">

                        <br>
                        <br><a href="#" class="btn btn-outline-info" data-toggle="collapse" data-target="#ingredients">Ingrédients</a>
                        <div id="ingredients" class="collapse" data-parent="#infos" >
                            <br>
                            <c:forEach var="i" items="${currentSandwich.ingredients}">
                                ${i.name}, 
                            </c:forEach>
                        </div> 
                        <br>

                        <br><a href="#" class="btn btn-outline-info" data-toggle="collapse" data-target="#allergen">Allergènes</a>
                        <div id="allergen" class="collapse" data-parent="#infos" >
                            <br>
                            <c:forEach var="a" items="${sandwichAllergens}">
                                ${a.name} - 
                            </c:forEach>
                        </div> 
                        <br>

                        <br><a href="#" class="btn btn-outline-info" data-toggle="collapse" data-target="#facts">Informations nutritionnelles</a>
                        <div id="facts" class="collapse" data-parent="#infos" >
                            <br> 
                            <table class="table smallText table-sm">
                                <tr>
                                    <th></th>
                                    <th>Au 100g :</th>
                                </tr>
                                <tr><td>Glucides</td><td> ${currentSandwich.facts.carbs}g</td></tr>
                                <tr><td>- dont sucres </td><td> ${currentSandwich.facts.sugars}g</td></tr>
                                <tr><td>Lipides</td><td> ${currentSandwich.facts.lipids}g</td></tr>
                                <tr><td>Protéines</td><td> ${currentSandwich.facts.proteins}g</td></tr>
                                <tr><td>Fibres</td><td> ${currentSandwich.facts.fibers}g</td></tr>
                                <tr><td>Teneur en sel</td><td> ${currentSandwich.facts.salt}g</td></tr>
                                <tr><td>Calories</td><td> ${currentSandwich.facts.kCal}</td></tr>
                            </table>

                        </div> 




                    </div>
                    <br><br><br>
                    <a href="MainController?section=composeMenu&step=2" class="btn btn-outline-dark">Personnaliser</a>
                </div>


            </div> 

                    <div class="row pageFoot" >
            <div class="col-md-2"></div>
            <div class="col-md-2"><a href="#" class="btn btn-outline-danger" role="button" data-toggle="modal" data-target="#cancel">Annuler</a> </div>
            <div class="col-md-6">Total des options :  
                +<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${currentLine.getOptionsFullPrice(order.getAppliedVAT())}" /> &euro; </div>
            <div class="col-md-2 nextLink"><a href="MainController?section=composeMenu&step=3" class="btn btn-primary" role="button">Suivant >></a></div>



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
        <script type="text/javascript" src="style/idleTimer.js"></script>
        
        
    </body>
</html>


