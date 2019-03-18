<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row"  id="categoryTitle">
    Nos offres
</div>

<div class="centerDisplayContent">
    <div class="card-columns">
        <c:forEach var="o" items="${offers}">
            <div class="card" style="width:250px; text-align: center;">
                <img id="productImg" class="card-img-top" src="${o.img}" alt="">
                <div class="card-body">
                    <c:if test="${o.discount > 0}">
                        -<fmt:formatNumber minFractionDigits="0" maxFractionDigits="0" value="${o.discount}" />%
                        <br>
                    </c:if>
                    <c:url var="offerURL" value="MainController?section=offers&offerId=${o.id}" />
                    <a href="${offerURL}" class="btn btn-info stretched-link">${o.name}</a>

                </div>
            </div>
        </c:forEach>

    </div>
</div>

<br><br>





