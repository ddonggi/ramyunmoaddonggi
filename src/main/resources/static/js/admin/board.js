window.addEventListener("load", function () {

    // var editBtn = document.querySelector("input[value='수정']");
    var delBtn = document.querySelector("input[value='삭제']");

    // editBtn.onclick = function (e) {

    //     if (confirm("수정하시겠습니까?") == false) {
    //         e.preventDefault();
    //     }
    //     else {
    //         alert("수정되었습니다.");
    //     }
    // }


    delBtn.onclick = function (e) {

        if (confirm("삭제하시겠습니까?") == false) {
            e.preventDefault();
        }
        else {
            alert("삭제되었습니다.");
        }
    }

})