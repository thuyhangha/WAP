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
    var turbo = 250;

    var myfontSize = {
        Tiny: "7pt",
        Small: "10pt",
        Medium: "12pt",
        Large: "16pt",
        "Extra Large": "24pt",
        XXL: "32pt"
    }
    initialize();

    function initialize(){
        document.getElementById("start").onclick = start;
        document.getElementById("stop").onclick = stop;
        document.getElementById("animation").onchange = animation;
        document.getElementById("fontsize").onchange = size;
        document.getElementById("turbo").onclick = speed;
        document.getElementById("text-area").disabled = true;
        disable(false);
    }


    function disable(value){
        document.getElementById("animation").disabled = value;
        document.getElementById("fontsize").disabled = value;
        document.getElementById("turbo").disabled = !value;
        document.getElementById("start").disabled = value;
        document.getElementById("stop").disabled = !value;
    }

    function start(){
        loopId = setInterval(frame, turbo);
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

    function animation(){
        var animationValue = document.getElementById("animation").value;
        document.getElementById("text-area").value = ANIMATIONS[animationValue];
        frames = document.getElementById("text-area").value.split("=====\n");
    }

    function size(){
        var fontsizeKey = document.getElementById("fontsize").value;
        var fontsizeValue = "";
        for(const key in myfontSize){
            if(key ==fontsizeKey){
                fontsizeValue = myfontSize[key];
            }
        }
        document.getElementById("text-area").style.fontSize = fontsizeValue;
    }

    function speed(){
        if(document.getElementById("turbo").checked === true){
            turbo = 50;
        } else {
            turbo = 250;
        }
    }
}



