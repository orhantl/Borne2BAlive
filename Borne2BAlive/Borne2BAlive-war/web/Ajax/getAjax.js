
function getXhr() {
    var xhr = null;
    if (window.XMLHttpRequest) // Firefox et autres
        xhr = new XMLHttpRequest();
    else if (window.ActiveXObject) { // Internet Explorer
        try {
            xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
    }
    else { // XMLHttpRequest non supporté par le navigateur
        alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest...");
        xhr = false;
    }
    return xhr;
}

function addToCart(){
    var xhr = getXhr();
    var url = "MainController?section=cart&zone=add&item=${p.id}";
    xhr.onreadystatechange = function (){
        if(xhr.readyState == 4 && xhr.status == 200){
            var elem = document.getElementById("product");
            var contenu = xhr.responseText;            
            elem.innerHTML = contenu;
        }
    };
    xhr.open("GET",url,true)
    xhr.send(null);
}
/*
"/WEB-INF/catalog/catalog.jsp"

"MainController?section=cart&zone=add&item=${p.id}"*/