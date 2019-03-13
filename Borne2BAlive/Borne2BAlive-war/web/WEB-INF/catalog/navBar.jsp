<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="navBar">
    <div class="row navBarIcons">

        <c:forEach var="c" items="${navBar}">
            <div class="col">
                <a href="MainController?section=category&id=${c.id}"><img src="${c.img}" alt="${c.name}" width="80" class="rounded" > </a>
            </div>
        </c:forEach>

    </div>

    <div class="row navBarText">

        <c:forEach var="c" items="${navBar}">
            <div class="col">
                <a href="MainController?section=category&id=${c.id}">${c.name}</a>
            </div>
        </c:forEach>

    </div>
</div>
<br>





