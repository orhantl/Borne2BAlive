<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row"  id="categoryTitle">
    Menus
</div>

<div class="centerDisplayContent">
    <div class="card-columns">
        <c:forEach var="m" items="${MenusAvailable}">
            <div class="card" style="width:250px; text-align: center;">
                <img id="productImg" class="card-img-top" src="${m.img}" alt="">
                <div class="card-body">
                    <h6 class="card-title"><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${m.price * (100 + order.appliedVAT) /100}" /> &euro;</h6>
                    <c:url var="composeMenu" value="MainController?section=composeMenu&step=1&selectedMenu=${m.id}" />
                    <a href="${composeMenu}" class="btn btn-info stretched-link">${m.name}</a>

                </div>
            </div>
        </c:forEach>

    </div>
</div>

<br><br>
<c:forEach var="u" items="${MenusUnavailable}">
    ${u.name} : Indisponible, bientôt de retour 
</c:forEach>




