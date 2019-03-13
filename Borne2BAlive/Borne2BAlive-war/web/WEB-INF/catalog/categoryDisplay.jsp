<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3>${category.name}</h3>

<div class="card-columns">
    <c:forEach var="p" items="${Products}">
        <div id="categoryCard" class="card">
            <img id="productImg" class="card-img-top" src="${p.img}" alt="${p.name}">
            <div class="card-body">

                <h6 class="card-title">${p.name}</h6>


                <p><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${p.price * (100 + order.appliedVAT) /100}" /> &euro;</p>
                <a href="MainController?section=detail&step=1&category=${category.id}&product=${p.id}" type="button" class="btn btn-info btn-lg">Sélectionner</a>
                <br><br>


            </div>
        </div>
    </c:forEach>

</div>

<br><br>
<!--
<c:forEach var="u" items="${MenusUnavailable}">
    ${u.name} : Indisponible, bientôt de retour 
</c:forEach>

-->
