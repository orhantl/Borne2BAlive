<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<p><img src="Img/pictograms/cart.svg" alt="panier" id="cart">  VOTRE COMMANDE</p> 


<%--
 <i class="fas fa-shopping-cart"></i> 
--%>
<div>

    <c:if test="${empty order.lineList}">

        Votre panier est vide !
    </c:if>

    <c:if test="${not empty order.lineList}">
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Article</th>

                    <th></th>
                    <th>Qte</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>             

            <tbody>    
                <c:forEach var="l" items="${order.lineList}" varStatus="iterator">
                    <tr>
                        <td>${l.product.name}${l.menu.name}</td>


                        <td><a href="#" class="btn btn-success btn-lg" id="cartOperation">&minus; </a> </td>
                        <td> ${l.qty}</td>
                        <td><a href="#" class="btn btn-info btn-lg" id="cartOperation">&plus; </a></td>
                        <td><a href="#" data-toggle="modal" data-target="#removeItem${iterator.index}" >
                                <img src="Img/pictograms/trash.svg" alt="retirer de la commande" id="trash"></a></td>


                        <!-- Modal -->
                <div class="modal fade" id="removeItem${iterator.index}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLongTitle">Supprimer un article</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                Voulez-vous vraiment supprimer cet article?
                            </div>
                            <div class="modal-footer">
                                <a href="#" class="btn btn-secondary" data-dismiss="modal">Fermer</a>
                                <c:url value="MainController?section=cart&zone=remove&count=${iterator.index}" var="url150" />
                                <a href="${url150}" onclick="removeLine();return false" type="button" class="btn btn-primary" >Supprimer</a>
                            </div>
                        </div>
                    </div>
                </div>


                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>

    <p class="alignTextRight">
        Total : <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${prixTTC}" /> &euro;
        <c:url var="emptyCart" value="MainController?section=cart&zone=empty" />
    </p>
    <p>
        <a href="${emptyCart}" class="btn btn-outline-danger" data-toggle="modal" data-target="#emptyCart">Vider le panier</a> 
        <a href="MainController?section=OrderSummary&order=${order}" class="btn btn-success">Valider la commande</a>
    </p>

    <!-- Modal -->
    <div class="modal fade" id="emptyCart" role="dialog">
        <div class="modal-dialog modal-md modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Attention !</h4>
                </div> 
                <div class="modal-body">
                    <p>Vous êtes sur le point d'annuler votre commande</p>
                    <p>Appuyez sur "Retour" pour poursuivre votre commande. </p>
                    <p>Appuyez sur "Confirmer" pour abandonner la commande</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-info" data-dismiss="modal">Retour</a>
                    <a href="MainController?section=cart&zone=empty" class="btn btn-danger" >Confirmer</a>
                </div>
            </div>
        </div>
    </div>



</c:if>



<hr>