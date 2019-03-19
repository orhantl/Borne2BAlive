<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="row"  id="categoryTitle">
${category.name}
</div>


<div class="centerDisplayContent">
    <div class="card-columns">
        <c:forEach var="p" items="${Products}">
            <div id="categoryCard" class="card" style="width:250px;">
                <img id="productImg" class="card-img-top" src="${p.img}" alt="${p.name}">
                <div class="card-body">


                    <p><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${p.price * (100 + order.appliedVAT) /100}" /> &euro;</p>
                    <c:url var="url150" value="MainController?section=detail&step=1&category=${category.id}&product=${p.id}" />
                    <a href="${url150}" class="btn btn-info stretched-link">${p.name}</a>

                </div>
            </div>
        </c:forEach>

    </div>
</div>
<br><br>