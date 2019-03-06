<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="row navBar">
    <div class="col-md-1"></div>
    <div class="col-md-1"></div>

    <c:forEach var="c" items="${navBar}">
        <div class="col-md-1">
            <figure>
                <img src="${c.img}" alt="${c.name}" width="70" class="rounded" > 
                <figcaption>${c.name}</figcaption>
            </figure>
        </div>
    </c:forEach>

    <div class="col-md-1"></div>
    <div class="col-md-1"></div>
</div>

<br><br>





