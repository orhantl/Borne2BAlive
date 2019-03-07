<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
ICI C'est le coeur de la page, le display <br>

<c:forEach var="p" items="${products}">
    ${p.name} : <a href="MainController?section=cart&zone=add&item=${p.id}">ajouter au panier</a> ${p.id}<br> 
</c:forEach>

<hr>