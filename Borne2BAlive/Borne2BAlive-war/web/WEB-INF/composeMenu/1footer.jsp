<div class="row pageFoot" >
    <div class="col-md-2"></div>
    <div class="col-md-2"><a href="#" class="btn btn-outline-danger" role="button" data-toggle="modal" data-target="#cancel">Annuler</a> </div>
    <div class="col-md-6">Total des options : ${currentLine.optionPriceApplied} &euro; </div>
    <div class="col-md-2 nextLink"><a href="MainController?section=composeMenu&step=3" class="btn btn-primary" role="button">Suivant >></a></div>



    <!-- Modal -->
    <div class="modal fade" id="cancel" role="dialog">
        <div class="modal-dialog modal-md modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">Attention !</h4>
                </div>
                <div class="modal-body">
                    <p>Vous �tes sur le point de supprimer vos modifications. </p>
                    <p>Appuyez sur "Retour" si vous souhaitez finaliser votre menu. </p>
                    <p>Appuyez sur "Confirmer" si vous souhaitez revenir � l'�cran d'accueil</p>
                </div>
                <div class="modal-footer">
                    <a href="#" class="btn btn-info" data-dismiss="modal">Retour</a>
                    <a href="MainController?section=Menus" class="btn btn-danger">Confirmer</a>
                </div>
            </div>
        </div>
    </div>




</div> 
