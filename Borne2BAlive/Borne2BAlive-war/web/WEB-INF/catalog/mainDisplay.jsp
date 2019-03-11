<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
ICI C'est le coeur de la page, le display <br>

<div id="product">
<c:forEach var="p" items="${products}">
    ${p.name} : <a href="MainController?section=cart&zone=add&item=${p.id}" >ajouter au panier</a><br> 
</c:forEach>
</div>
<hr>

