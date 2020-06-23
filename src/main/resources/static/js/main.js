/**
 * 
 */

window.addEventListener("load", function() {
    var cancelBtn = document.querySelector("#cancel");
    var first = document.querySelector(".first");
    cancelBtn.onclick = function() {
        first.style.display ="none";
    }
});