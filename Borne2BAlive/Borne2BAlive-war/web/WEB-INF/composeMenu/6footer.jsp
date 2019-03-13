<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="row pageFoot" >
    <c:url var="back" value="MainController?section=composeMenu&step=5" />
    <div class="col-md-2"><a href="${back}" class="btn btn-outline-info" role="button" >Retour</a> </div>
    <div class="col-md-2"><a href="#" class="btn btn-outline-danger" role="button" data-toggle="modal" data-target="#cancel">Annuler</a> </div>
    <div class="col-md-6">Total des options :  
        +<fmt:formatNumber minFractionDigits="2" maxFractionDigits="2" value="${currentLine.optionPriceApplied * (100 + currentOrder.appliedVAT) /100}" /> &euro; </div>
    



    <!-- Modal -->
    <div class="modal fade" id="cancel" role="dialog">
        <div class="modal-dialog modal-md modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Attention !</h4>
                </div>
                <div class="modal-body">
                    <p>Vous êtes sur le point de supprimer vos modifications. </p>
                    <p>Appuyez sur "Retour" si vous souhaitez finaliser votre menu. </p>
                    <p>Appuyez sur "Confirmer" si vous souhaitez revenir à l'écran d'accueil</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-info" data-dismiss="modal">Retour</a>
                    <a href="MainController?section=Menus" class="btn btn-danger">Confirmer</a>
                </div>
            </div>
        </div>
    </div>




</div> 
