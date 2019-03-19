var page = document.getElementsByTagName('body')[0];
var timeout = setTimeout("location.href = 'MainController?section=kill';",6000000);

page.onclick = resetTimeout;
page.onmousemove = resetTimeout;

function resetTimeout() {
    clearTimeout(timeout);
    timeout = setTimeout("location.href = 'MainController?section=kill';",6000000);
}