'use strict'

$(function () {
    let fail = false;
    let start = false;

    initial();
    function initial() {
        $("#start").click(startFunc);
    }
    
    function startFunc() {
        start = true;
        fail = false;
        $(".example").text("");

        $(".boundary").mouseover(loseFunc);

        $(".outside").mouseover(loseFunc);
    }

    function checkWinFunc() {
        if (fail == false && start == true){
            $(".example").text("You win!");
            //alert("You win !!!");
        }
    }

    function loseFunc() {
        $(".example").text("You lost !!!");
        fail = true;
        //alert("You lost !!!");
    }

    $("#end").mouseover(checkWinFunc);
});