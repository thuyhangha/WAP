'use strict';

$(document).ready(function () {
    $(function () {
        $('#loading').hide();
        $(document).ajaxStart(function () {
            $('#loading').show();
        }).ajaxStop(function () {
            $('#loading').hide();
        });
    });

    //Show autocomplete when user typing in search box
    //$("#term").keyup(requestAutoCompleteData);
    
    //Trigger user press enter key
    $('#term').keypress(function (event) {
        var keycode = (event.keyCode ? event.keyCode : event.which);
        if (keycode == '13') {
            requestData();
        }
    });
    //Show result when user click lookup button
    $("#btnLookup").click(requestData);

//    function requestAutoCompleteData() {
//        var term = $("#term").val();
//        var requestURL = "http://localhost:8080/OnlineDictionary/dictServlet";
//        if (term !== '') {
//            $.post(requestURL, {"term": term}).done(getAutoCompleteData).error(onRequestError);
//
//        }
//    }
    function requestData() {
        var term = $("#term").val();
        var requestURL = "http://localhost:8080/OnlineDictionary/dictServlet";
        if (term !== '') {
            $.post(requestURL, {"term": term}).done(getDictionaryData).error(onRequestError);

        }
    }

    function getDictionaryData(data) {
        var result = JSON.parse(data);
        result = result.dictionaryData;
        var searchResult = '';
        $.each(result, function (index, value) {
            searchResult += "<dl>";
            searchResult += "<dt class='word'>";
            searchResult += value.word;
            searchResult += "<span class='wordType'>(" + value.wordType + ")</span></dt>";
            searchResult += "<dd class='definition'>" + value.definition + "</dd>";
            searchResult += "</dl>";
        });
        if (searchResult !== '') {
            $("#result").html(searchResult);
        } else {
            $("#result").html("<div class='notFound'>Search not found!</div>");
        }

    }

//    function getAutoCompleteData(data) {
//        var result = JSON.parse(data);
//        result = result.dictionaryData;
//        var availableTerms = {};
//        $.each(result, function (index, value) {
//            availableTerms.push(value.word);
//        });
//        $("#term").autocomplete({
//            source: availableTerms
//        });
//    }

    function onRequestError(xhr, status, exceptio) {
        console.log(xhr, status, exception);
    }
});


