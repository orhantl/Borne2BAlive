<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h3>${c.name}</h3>

<div class="card-columns">
    <c:forEach var="p" items="${Products}">
        <div id="categoryCard" class="card">
            <img id="productImg" class="card-img-top" src="${p.img}" alt="${p.name}">
            <div class="card-body">

                <h6 class="card-title">${p.name}</h6>
                
                
                <p><fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${p.price * (100 + order.appliedVAT) /100}" /> &euro;</p>
                <button type="button" class="btn btn-info btn-lg">Sélectionner</button>
                <br><br>
                <a href ="MainController?section=category&product=${p.id}" class="btn btn-outline-secondary bt-sm" data-toggle="modal" data-target="#nutritionInfo" >
                    <img id="infoIcon" src="Img/pictograms/info.svg" alt="infos"></img></a>
                    
                    <div class="modal fade" id="nutritionInfo" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Informations nutritionnelles</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fermer</button>
        
      </div>
    </div>
  </div>
</div>
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
