<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class="catSquareDisplay">
    
    
    <c:forEach var="c" items="${navBar}">
        <c:url var="url151" value="MainController?section=category&id=${c.id}" />
        <a href="${url151}">
            <div class="col catSquare">
                <br><br><br>
                <div id ="catTitle" style="text-decoration: none;">${c.name} </div>
            </div>
        </a>
    </c:forEach>

</div>


