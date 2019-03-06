<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="card-columns">
    <c:forEach var="m" items="${MenusAvailable}">
        <div class="card" style="width:160px; text-align: center;">
            <img class="card-img-top" src="${m.img}" alt="">
            <div class="card-body">
                <h6 class="card-title">${m.name}</h6>
                <c:set var="VAT" value="${VAT}" />
                <c:set var="preTaxPrice" value="${m.price}" />
                <c:url var="composeMenu" value="MainController?section=composeMenu&selectedMenu=${m.id}" />
                <a href="#myModal${m.id}" class="btn btn-primary stretched-link" data-toggle="modal">
                    <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${preTaxPrice * (100 + VAT) /100}" /> &euro;
                </a>

            </div>
        </div>

        <!-- The Modal -->
        <div class="modal" id="myModal${m.id}">
            <div class="modal-dialog modal-xl modal-dialog-centered">
                <div class="modal-content">
                    <div class="modal-body">
                        <c:import url="${composeMenu}" />
                    </div>

                </div>
            </div>
        </div>

    </c:forEach>

</div>

<br><br>
<c:forEach var="u" items="${MenusUnavailable}">
    ${u.name} : Indisponible, bientôt de retour 
</c:forEach>



