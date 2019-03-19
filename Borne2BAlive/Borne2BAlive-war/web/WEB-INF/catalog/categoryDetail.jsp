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

            <form action="MainController?section=detail&step=2&product=${product.id}"  method="POST">
                <div class="row pageHead">
                    <div class="col-md-12">
                        <h5>${product.name}</h5>
                        <h6>${product.description}</h6>
                    </div>
                </div> 

                <div class="row">
                    <div class="col-md-3">
                        <div class="contentSandwichImg">
                            <img class="imgSandwich sandwich" src="${product.img}" alt="${product.name}" height="300" >
                        </div>

                    </div>

                    <div class="col-md-5 contentSandwichOptions">
                        <div id="infos">

                            <br>
                            <br><a href="#" class="btn btn-info" data-toggle="collapse" data-target="#ingredients">Ingrédients</a>
                            <div id="ingredients" class="collapse" data-parent="#infos" >
                                <br>
                                <c:forEach var="i" items="${product.ingredients}">
                                    ${i.name}, 
                                </c:forEach>
                            </div> 
                            <br>

                            <br>
                            <c:if test="${not empty allergens}">
                                <a href="#" class="btn btn-success" data-toggle="collapse" data-target="#allergen">Allergènes</a>
                                <div id="allergen" class="collapse" data-parent="#infos" >
                                    <br>


                                    <c:forEach var="a" items="${allergens}">
                                        ${a.name} - 
                                    </c:forEach>

                                </div>
                            </c:if>
                            <br>

                            <br><a href="#" class="btn btn-warning" data-toggle="collapse" data-target="#facts">Informations nutritionnelles</a>
                            <div id="facts" class="collapse" data-parent="#infos" >
                                <br> 
                                <u>Au 100g :</u><br>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">valeur nutritionnelle</th>
                                            <th scope="col"></th>
                                            <th scope="col">pour 100 gr</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <tr><td>Glucides</td> <td></td> <td> ${p.facts.carbs}</td></tr>
                                    <tr><td>- dont sucres </td><td></td><td> ${p.facts.sugars}</td></tr>
                                    <tr><td>Lipides</td><td></td><td> ${p.facts.lipids}</td></tr>
                                    <tr><td>Protéines</td><td></td><td> ${p.facts.proteins}</td></tr>
                                    <tr><td>Fibres</td><td></td><td> ${p.facts.fibers}</td></tr>
                                    <tr><td>Teneur en sel</td><td></td><td> ${p.facts.salt}</td></tr>
                                    <tr><td>Calories</td><td></td><td> ${p.facts.kCal}</td></tr>
                                    </tbody>
                                </table>
                            </div> 
                            <br><br>
                            <c:if test="${not empty option}">
                                <a href="#" class="btn btn-light" data-toggle="collapse" data-target="#custom">Personnaliser votre ${product.name}</a>
                                <div id="custom" class="collapse" data-parent="#infos" >

                                    <br><br>
                                    <c:forEach var="o" items="${option}">

                                        <div>

                                            <section id="first" class="section">
                                                <div class="container">
                                                    <input type="checkbox" name="options" id="checkbox-${o.id}" value="${o.id}" style="visibility:hidden; display : none">
                                                    <label for="checkbox-${o.id}">
                                                        <span class="checkbox">${o.name}
                                                            <c:if test="${o.price > 0}">
                                                                + <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${o.price.getProductFullPrice(currentOrder.appliedVAT)}" /> &euro;
                                                            </c:if>
                                                        </span>
                                                    </label>
                                                </div>
                                            </section>
                                        </div>
                                        <br>
                                    </c:forEach>
                                    <br>

                                </c:if> 

                            </div>
                        </div>

                    </div>
                    <br>
                    <div class="col-md-4 ">
                        <c:if test="${not empty size}">
                            <label class="btn btn-danger" >Choisir la taille</label>
                            <br><br>
                            <c:forEach var="s" items="${size}">
                                <div>
                                    <section id="first" class="section">
                                        <div class="container">
                                            <input type="radio" name="size" id="radio-${s.id}" value="${s.id}" style="visibility:hidden; display : none">
                                            <label for="radio-${s.id}">
                                                <span class="radio">${s.name}
                                                    <c:if test="${s.price > 0}">
                                                        + <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${s.price.getOptionalFullPrice(currentOrder.appliedVAT)}" /> &euro;
                                                    </c:if>
                                                </span>
                                            </label>
                                        </div>
                                    </section>
                                </div>
                            </c:forEach>

                            <br>
                        </c:if> 

                    </div>


                </div> 

                <div class="row pageFoot" >


                    <div class="col-offset-3 col-md-2"><a href="#" class="btn btn-outline-dark" role="button" data-toggle="modal" data-target="#cancel">Annuler</a></div>


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
                                    <a href="MainController?section=catalog" class="btn btn-danger">Confirmer</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-5">Prix : <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${product.price}" /> &euro; </div>

                    <div class="col-md-2 nextLink">
                        <button type ="submit" class="btn btn-warning btn-lg" role="button">Ajouter au panier </button>
                    </div>

                </div> 

                <br>
            </form>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>


