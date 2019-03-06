 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row headTitle">
  <div class="col-sm-1"></div>
  <div class="col-sm-1"><img src="Img/patrick.jpg" alt="" class="rounded-circle" width="60" ></div>
  <div class="col-sm-8">borne 2b alive</div>
  <c:url var="quit" value="MainController" />
  <div class="col-sm-1"><a href="${quit}" class="btn btn-danger">Quitter</a></div>
  <div class="col-sm-1"></div>
</div> 