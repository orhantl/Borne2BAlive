<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<p class="centerDisplayContent hamburger"><img src="Img/pictograms/cart.svg" alt="panier" id="cart">  VOTRE COMMANDE</p> 

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
                        <td>${l.product.name}${l.menu.name}
                            <c:if test="${not empty l.optionList }">
                                :<c:forEach var="o" items="${l.optionList}">
                                ${o.name}
                            </c:forEach>
                            
                            </c:if> 
                            
                        </td>


                        <td>
                            <c:if test="${l.qty > 1}">                            
                                <a href="MainController?section=cart&zone=minus&count=${iterator.index}" class="btn btn-outline-secondary" id="cartOperation">&minus; </a> </td>                        
                            </c:if>

                        <td> ${l.qty}</td>
                        <td>
                            <c:if test="${l.qty < 10}">

                                <a href="MainController?section=cart&zone=plus&count=${iterator.index}" class="btn btn-outline-info" id="cartOperation">&plus; </a></td>
                            </c:if>
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
                                <a href="${url150}" onclick="removeLine();
                                        return false" type="button" class="btn btn-primary" >Supprimer</a>
                            </div>
                        </div>
                    </div>
                </div>
                </tr>

            </c:forEach>

            </tbody>
        </table>
    </div>

    <div class="centerDisplayContent">
        <p class="cartPrice">
            Total : <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${prixTTC}" /> &euro;
            <c:url var="emptyCart" value="MainController?section=cart&zone=empty" />
        </p>
        <p>
            <a href="${emptyCart}" class="btn btn-outline-danger" data-toggle="modal" data-target="#emptyCart">Vider</a> 
            <a href="MainController?section=OrderSummary&order=${order}" class="btn btn-success">Commander</a>
        </p>
    </div>


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



