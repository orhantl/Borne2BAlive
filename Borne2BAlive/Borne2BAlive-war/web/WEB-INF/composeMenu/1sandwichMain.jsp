<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:url var="pageHead" value="MainController?section=composeMenu&zone=header" />
<c:import url="${pageHead}" />

<div class="row">
    <div class="col-md-9">

    </div>

    <div class="col contentSandwichImg">
        <img class="imgSandwich sandwich" src="${currentSandwich.img}" alt="${currentSandwich.name}" height="450" >
    </div>



    <div class="col-md-3 contentSandwichOptions" id="#infos">

        <br><a href="#" class="btn btn-warning" data-toggle="collapse" data-target="#facts">Informations nutritionnelles</a>
        <div id="facts" class="collapse">
           <br> <u>Ingrédients :</u><br>
            <c:forEach var="i" items="${currentSandwich.ingredients}">
                ${i.name}, 
            </c:forEach>
            <br><br>
            <u>Au 100g :</u><br>
            <table>
                <tr><td>Glucides</td><td> ${currentSandwich.facts.carbs}g</td></tr>
                <tr><td>- dont sucres </td><td> ${currentSandwich.facts.sugars}g</td></tr>
                <tr><td>Lipides</td><td> ${currentSandwich.facts.lipids}g</td></tr>
                <tr><td>Protéines</td><td> ${currentSandwich.facts.proteins}g</td></tr>
                <tr><td>Fibres</td><td> ${currentSandwich.facts.fibers}g</td></tr>
                <tr><td>Teneur en sel</td><td> ${currentSandwich.facts.salt}g</td></tr>
                <tr><td>Calories</td><td> ${currentSandwich.facts.kCal}</td></tr>
            </table>
            
        </div> 
        <br>
        <br><a href="#" class="btn btn-success" data-toggle="collapse" data-target="#allergen">Allergènes</a>
        <div id="allergen" class="collapse">
            <br>
            <c:forEach var="a" items="${sandwichAllergens}">
                ${a.name} - 
            </c:forEach>
            
            
            
        </div> 
<br><br>
        <a href="MainController?section=composeMenu&step=2" class="btn btn-outline-dark">retirer des ingrédients</a>
    </div>


</div> 

<c:url var="pageFoot" value="MainController?section=composeMenu&zone=footer" />
<c:import url="${pageFoot}" />

<br>



