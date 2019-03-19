<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row"  id="categoryTitle">
    ${offer.name}
</div>

<div class="centerDisplayContent">
    
    <div class="card-columns">
        <c:forEach var="p" items="${offer.products}">
            <div class="card" style="width:250px; text-align: center;">
                <img id="productImg" class="card-img-top" src="${p.img}" alt="">
                <div class="card-body">
                    <h6 class="card-title">
                        <c:if test="${offer.discount > 0}">
                            <strike><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${p.price * (100 + order.appliedVAT) /100}" /> &euro;</strike>
                            <strong><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${(p.price * (100 + order.appliedVAT) /100)*(100 - offer.discount)/100}" /> &euro;</strong>
                        </c:if>
                        <c:if test="${offer.discount == 0}">
                            <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${(p.price * (100 + order.appliedVAT) /100)*(100 - offer.discount)/100}" /> &euro;
                        </c:if>
                    </h6>
                    <c:url var="select" value="MainController?section=detail&step=1&product=${p.id}" />
                    <a href="${select}" class="btn btn-info stretched-link">${p.name}</a>

                </div>
            </div>
        </c:forEach>

    </div>
</div>

<br><br>
<c:forEach var="u" items="${MenusUnavailable}">
    ${u.name} : Indisponible, bientôt de retour 
</c:forEach>




