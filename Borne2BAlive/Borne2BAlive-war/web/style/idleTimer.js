var page = document.getElementsByTagName('body');
var timeout = setTimeout("location.href = 'MainController?section=kill';",60000);

page.onclick = resetTimeout;
page.onmousemove = resetTimeout;

function resetTimeout() {
    clearTimeout(timeout);
    timeout = setTimeout("location.href = 'MainController?section=kill';",60000);
}