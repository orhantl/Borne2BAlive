function getPrice(){
    var elems = document.getElementsByName("size");
    var selectedOption = 0;
    for(var i = 0; i < elems.length; i++){
		if(elems[i].checked){
			civ = elems[i].value+" ";
		}
	}
}

