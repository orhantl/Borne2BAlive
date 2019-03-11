
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<p><i class="fas fa-shopping-cart"></i> VOTRE COMMANDE</p> 

<%--
${order.id}
${order.appliedVAT}

--%>
<div class="container">
    <c:if test="${prixTTC == 0}">
        Votre panier est vide !
    </c:if>

        <c:if test="${prixTTC > 0}">
        <table class="table table-hover">
            <thead>
            <th>Article</th>
            <th>Quantité</th>
            </thead>      
            <tbody>    
                <c:forEach var="l" items="${order.lineList}">
                    <tr>
                        <td>${l.product.name}</td>
                        <td>${l.qty}</td>
                    </tr>

                </c:forEach>

            </tbody>
        </table>
    </div>


    Total  ${prixTTC} &euro;

    <p><a href="MainController?section=cart&zone=empty" class="btn btn-danger">Vider la commande</a></p>

    <p><a href="MainController?section=OrderSummary&order=${order}" class="btn btn-success">Valider la commande</a></p>
</c:if>



<hr>