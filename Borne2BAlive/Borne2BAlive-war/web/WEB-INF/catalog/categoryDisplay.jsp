<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3 id="categoryTitle">${category.name}</h3>
<div class="centerDisplayContent">
    <div class="card-columns">
        <c:forEach var="p" items="${Products}">
            <div id="categoryCard" class="card" style="width:250px;">
                <img id="productImg" class="card-img-top" src="${p.img}" alt="${p.name}">
                <div class="card-body">

                    <p><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${p.price * (100 + order.appliedVAT) /100}" /> &euro;</p>
                    <a href="MainController?section=detail&step=1&category=${category.id}&product=${p.id}" class="btn btn-info">${p.name}</a>

                </div>
            </div>
        </c:forEach>

    </div>
</div>
<br><br>
<!--
<c:forEach var="u" items="${MenusUnavailable}">
    ${u.name} : Indisponible, bientôt de retour 
</c:forEach>

-->
