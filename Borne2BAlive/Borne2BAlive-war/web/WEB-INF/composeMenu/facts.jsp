<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




Glucides : ${currentSandwich.facts.carbs}g (dont sucres : ${currentSandwich.facts.sugars}g) | <br>
Lipides : ${currentSandwich.facts.lipids}g | <br>
Protéïnes : ${currentSandwich.facts.proteins}g | <br>
Fibres : ${currentSandwich.facts.fibers}g | <br>
Teneur en sel : ${currentSandwich.facts.salt}g | <br>
calories : ${currentSandwich.facts.kCal}g | 

