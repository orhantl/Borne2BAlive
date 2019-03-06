<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navBar">
    <div class="row navBarIcons">

        <c:forEach var="c" items="${navBar}">
            <div class="col">
                <img src="${c.img}" alt="${c.name}" width="80" class="rounded" > 
            </div>
        </c:forEach>

    </div>

    <div class="row navBarText">

        <c:forEach var="c" items="${navBar}">
            <div class="col">
                ${c.name}
            </div>
        </c:forEach>

    </div>
</div>
<br><br>





