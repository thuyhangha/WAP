/*
window.onload = function(){
    var startElement = document.getElementById("start");
    startElement.onclick = startFunction;

    function startFunction() {
        //document.getElementById("text-area").innerHTML = "Test";
    }
}*/

"use strict";

window.onload = function(){
    var loopId = null;
    var frames = ANIMATIONS["blank"].split("=====\n");
    var index = 0;
    var speed = 250;

    initialize();

    function initialize(){
        //alert("onload");
        document.getElementById("start").onclick = start;
        document.getElementById("stop").onclick = stop;
        document.getElementById("animation").onchange = changeAnimation;
        document.getElementById("fontsize").onchange = changeSize;
        document.getElementById("turbo").onclick = changeSpeed;
        disable(false);
        document.getElementById("text-area").disabled = true;
    }

    function disable(b){
        document.getElementById("animation").disabled = b;
        document.getElementById("fontsize").disabled = b;
        document.getElementById("turbo").disabled = !b;
        document.getElementById("start").disabled = b;
        document.getElementById("stop").disabled = !b;
    }
    function start(){
        loopId = setInterval(frame, speed);
        function frame(){
            if(index == frames.length) {
                index = 0;
            }
            document.getElementById("text-area").value = frames[index++];
        }
        disable(true);
    }

    function stop(){
        clearInterval(loopId);
        disable(false);
    }

    function changeAnimation(){
        document.getElementById("text-area").value = ANIMATIONS["" + document.getElementById("animation").value];
        frames = document.getElementById("text-area").value.split("=====\n");
    }

    function changeSize(){
        document.getElementById("text-area").style.fontSize = "" + document.getElementById("fontsize").value;
    }

    function changeSpeed(){
        speed = 250;
        if(document.getElementById("turbo").checked === true){
            speed = 50;
        }
    }
}



