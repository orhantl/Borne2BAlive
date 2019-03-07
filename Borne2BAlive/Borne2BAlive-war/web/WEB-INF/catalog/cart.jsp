
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<p><i class="fas fa-shopping-cart"></i> VOTRE COMMANDE</p> 

<c:forEach var="l" items="${lines}">
    <p>${l.product.name} X ${l.qty}</p>
    
</c:forEach>

Total ${prixTTC} &euro;


<a href="#" class="btn btn-danger">Abandonner la commande</a>
<a href="#" class="btn btn-success">Valider la commande</a>
<hr>