
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="style/productDetail.css">
        <link rel="stylesheet" href="style/catalog.css">
        <title>Borne2BAlive - detail product</title>
    </head>
    <body>

        <c:url var="pageHead" value="MainController?section=catalog&zone=pageHead" />
        <c:import url="${pageHead}" />

        <!-- BEGINNING CENTRAL WINDOW -->        
        <div class="globalContentProduct">
            <form action="MainController?section=detail&step=2&product=${product.id}"  method="POST">
                <!-- BEGINNING PRODUCT HEADER -->                
                <div class="pageHead">
                    <div class="col-md-12">
                        <h5>${product.name}</h5>
                        <h6>${product.description}</h6>
                    </div>
                </div> 
                <!-- BEGINNING PRODUCT HEADER -->                   
                <!-- BEGINNING CENTRAL PART -->
                <div class="mainContent">
                    <div class="productImg">
                        <img class="img" src="${product.img}" alt="${product.name}" height="300" >
                        <br><figcaption class="ingredients">
                            <c:if test="${not empty product.ingredients}">

                                Ingrédients : <c:forEach var="i" items="${product.ingredients}">
                                    ${i.name}, 
                                </c:forEach>
                            </figcaption><br>
                        </c:if>
                        <div class="infos">
                            <!--ALLERGENS-->
                            <div class="allergens">
                                <c:if test="${not empty allergens}">
                                    <div><a href="#" class="btn btn-outline-info" role="button" data-toggle="modal" data-target="#allergen">Allergènes</a></div>
                                    <div class="modal fade" id="allergen" role="dialog">
                                        <div class="modal-dialog modal-md modal-dialog-centered">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title">Allergènes contenus dans ce produit</h4>
                                                </div>
                                                <div class="modal-body">
                                                    <p><c:forEach var="a" items="${allergens}">
                                                            ${a.name}<br>
                                                        </c:forEach></p>
                                                </div>
                                                <div class="modal-footer">
                                                    <a href="#" class="btn btn-info" data-dismiss="modal">Fermer</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </div>
                            <br>
                            <!--NUTRITION FACTS-->
                            <div class="nutrition">
                                <div><a href="#" class="btn btn-outline-info" role="button" data-toggle="modal" data-target="#facts">Nutrition</a></div>
                                <div class="modal fade" id="facts" role="dialog">
                                    <div class="modal-dialog modal-md modal-dialog-centered">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Informations nutritionnelles sur ce produit</h4>
                                            </div>
                                            <div class="modal-body">
                                                <table class="table table-hover">
                                                    <thead>
                                                        <tr>
                                                            <th scope="col">valeur nutritionnelle</th>
                                                            <th scope="col"></th>
                                                            <th scope="col">pour 100 gr</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr><td>Glucides</td> <td></td> <td> ${product.facts.carbs}</td></tr>
                                                        <tr><td>- dont sucres </td><td></td><td> ${product.facts.sugars}</td></tr>
                                                        <tr><td>Lipides</td><td></td><td> ${product.facts.lipids}</td></tr>
                                                        <tr><td>Protéines</td><td></td><td> ${product.facts.proteins}</td></tr>
                                                        <tr><td>Fibres</td><td></td><td> ${product.facts.fibers}</td></tr>
                                                        <tr><td>Teneur en sel</td><td></td><td> ${product.facts.salt}</td></tr>
                                                        <tr><td>Calories</td><td></td><td> ${product.facts.kCal}</td></tr>
                                                    </tbody>
                                                </table>
                                            </div>
                                            <div class="modal-footer">
                                                <a href="#" class="btn btn-info" data-dismiss="modal">Fermer</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <br>
                            <!--CUSTOM-->

                            <c:if test="${not empty option}">
                                <div><a href="#" class="btn btn-outline-info" role="button" data-toggle="modal" data-target="#custom">Personnaliser</a></div>
                                <div class="modal fade" id="custom" role="dialog">
                                    <div class="modal-dialog modal-md modal-dialog-centered">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h4 class="modal-title">Personnaliser votre produit</h4>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <c:forEach var="o" items="${option}">

                                                    <div>

                                                        <section id="first" class="section">
                                                            <div class="container">
                                                                <input type="checkbox" name="options" id="checkbox-${o.id}" value="${o.id}" style="visibility:hidden; display : none">
                                                                <label for="checkbox-${o.id}">
                                                                    <span class="checkbox">${o.name}
                                                                        <c:if test="${o.price > 0}">
                                                                            + <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${o.getOptionalFullPrice(order.appliedVAT)}" /> &euro;
                                                                        </c:if>
                                                                    </span>
                                                                </label>
                                                            </div>
                                                        </section>
                                                    </div>
                                                    <br>
                                                </c:forEach>
                                            </div>
                                            <div class="modal-footer">
                                                <a href="#" class="btn btn-info" data-dismiss="modal">Enregistrer</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>    

                            </c:if>

                        </div>    
                    </div>

                    <!-- end of img section -->

                    <div class="productOptions">
                        <c:if test="${not empty size}">
                            <label class="btn btn-warning" >Choisir la taille</label>
                            <br><br>
                            <c:forEach var="s" items="${size}">
                                <div>
                                    <section id="first" class="section">
                                        <div class="container">
                                            <input type="radio" name="size" id="radio-${s.id}" value="${s.id}" style="visibility:hidden; display : none">
                                            <label for="radio-${s.id}">
                                                <span class="radio">${s.name}
                                                    <c:if test="${s.price > 0}">
                                                        + <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${s.getOptionalFullPrice(order.appliedVAT)}" /> &euro;
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

                    <div class="mainAction">
                        <div class="nextLink">
                            <button type ="submit" class="btn btn-warning btn-lg" role="button">
                                <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${product.getProductFullPrice(order.appliedVAT)}" /> &euro;  |  
                                Ajouter au panier </button>
                        </div>
                    </div>


                </div>
                <!-- END CENTRAL PART --> 

                <!-- BEGINNING FOOTER -->                
                <div class="productFooter">
                    <div class="cancelProduct"><a href="#" class="btn btn-outline-dark" role="button" data-toggle="modal" data-target="#cancel">Annuler</a>
                    </div>
                    <!-- Modal -->
                    <div class="modal fade" id="cancel" role="dialog">
                        <div class="modal-dialog modal-md modal-dialog-centered">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h4 class="modal-title">Attention !</h4>
                                </div>
                                <div class="modal-body">
                                    <p>Vous êtes sur le point d'annuler l'ajout de ce produit. </p>
                                    <p>Appuyez sur "Retour" si vous souhaitez ajouter ce produit à votre commande.</p>
                                    <p>Appuyez sur "Confirmer" si vous souhaitez revenir à l'écran d'accueil</p>
                                </div>
                                <div class="modal-footer">
                                    <a href="#" class="btn btn-info" data-dismiss="modal">Retour</a>
                                    <a href="MainController?section=catalog" class="btn btn-danger">Confirmer</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- END FOOTER -->
            </form>
        </div>
        <!-- END CENTRAL WINDOW -->

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
