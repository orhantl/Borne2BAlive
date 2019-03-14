<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row headTitle">
    <div class="col-sm-1"></div>
    <div class="col-sm-1">
        <c:url var="home" value="MainController?section=catalog" />
        <a href="${home}">
            <img src="Img/patrick.jpg" alt="" class="rounded-circle" width="60" >
        </a>
    </div>
    <div class="col-sm-8">borne 2b alive</div>
    <div class="col-sm-1"><a href="#" class="btn btn-danger" data-toggle="modal" data-target="#quit">Quitter</a></div>
    <div class="col-sm-1"></div>  
</div> 


<!-- Modal -->
<div class="modal fade" id="quit" role="dialog">
    <div class="modal-dialog modal-md modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Attention !</h4>
            </div>
            <div class="modal-body">
                <p>Vous �tes sur le point d'annuler votre commande</p>
                <p>Appuyez sur "Retour" pour poursuivre votre commande. </p>
                <p>Appuyez sur "Confirmer" pour abandonner la commande</p>
            </div>
            <div class="modal-footer">
                <a href="#" class="btn btn-info" data-dismiss="modal">Retour</a>
                <c:url var="quit" value="MainController?section=kill" />
                <a href="${quit}" class="btn btn-danger">Confirmer</a>
            </div>
        </div>
    </div>
</div>