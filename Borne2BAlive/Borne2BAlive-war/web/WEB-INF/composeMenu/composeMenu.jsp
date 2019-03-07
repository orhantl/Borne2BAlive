<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<c:url var="pageHead" value="MainController?section=composeMenu&zone=header" />
<c:import url="${pageHead}" />

<div class="row">
    <div class="col">

    </div>

    <div class="col contentSandwichImg">
        <img class="imgSandwich sandwich" src="${currentSandwich.img}" alt="${currentSandwich.name}" height="450" >
    </div>



    <div class="col contentSandwichOptions" id="#infos">

        <br><a href="#" class="btn btn-warning" data-toggle="collapse" data-target="#facts">Informations nutritionnelles</a>
        <div id="facts" class="collapse">
            <br>
            Glucides : ${currentSandwich.facts.carbs}g <br>
            - dont sucres : ${currentSandwich.facts.sugars}g <br>
            Lipides : ${currentSandwich.facts.lipids}g <br>
            Protéïnes : ${currentSandwich.facts.proteins}g<br>
            Fibres : ${currentSandwich.facts.fibers}g<br>
            Teneur en sel : ${currentSandwich.facts.salt}g<br>
            calories : ${currentSandwich.facts.kCal}g<br>
        </div> 
        <br>
        <br><a href="#" class="btn btn-success" data-toggle="collapse" data-target="#allergen">Allergènes</a>
        <div id="allergen" class="collapse">
            <br>
            Glucides : ${currentSandwich.facts.carbs}g <br>
            - dont sucres : ${currentSandwich.facts.sugars}g <br>
            Lipides : ${currentSandwich.facts.lipids}g <br>
            Protéïnes : ${currentSandwich.facts.proteins}g<br>
            Fibres : ${currentSandwich.facts.fibers}g<br>
            Teneur en sel : ${currentSandwich.facts.salt}g<br>
            calories : ${currentSandwich.facts.kCal}g<br>
        </div> 
<br><br>
        <a href="#" class="btn btn-outline-dark">retirer des ingrédients</a>
    </div>


</div> 

<c:url var="pageFoot" value="MainController?section=composeMenu&zone=footer" />
<c:import url="${pageFoot}" />

<br>



