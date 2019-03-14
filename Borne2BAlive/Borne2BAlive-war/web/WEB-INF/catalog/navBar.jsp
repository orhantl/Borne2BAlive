<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


    <div class="row navBar">
        <c:forEach var="c" items="${navBar}">
            <div class="col ">
                <a href="MainController?section=category&id=${c.id}">
                    <figure>
                        <img src="${c.img}" alt="${c.name}" width="80" class="rounded navBarIcons" >
                        <figcaption>
                            <br>
                            ${c.name}
                        </figcaption>
                    </figure>
                </a>
            </div>
        </c:forEach>

    </div>



<br>





