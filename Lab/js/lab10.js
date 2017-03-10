'use strict'

$(function() {
    let URL = "http://jsonplaceholder.typicode.com";
    let USER = "/users/";
    let POSTS_BY_USER = "/posts?userId=";
    let COMMENTS_BY_POST = "/comments?postId=";

    $("#btnGo").click(GoFunc);

    function GoFunc() {
        var userId = $("#userId").val();

        $.ajax({
            "url": URL + USER + userId,
            "type": "GET",
            "success": userSuccess,
            "error": ajaxError
        });

        $.ajax({
            "url": URL + POSTS_BY_USER + userId,
            "type": "GET",
            "success": postByUserSuccess,
            "error": ajaxError
        });
    }

    function userSuccess(user) {
        $('#lblName').text(user.name);
        $('#lblUserName').text(user.username);
        $('#lblEmail').text(user.email);
        $('#lblAddress').text(user.address.street +
                            " " + user.address.suite +
                            ", " + user.address.city +
                            ", " + user.address.zipcode);
    }

    function postByUserSuccess(posts) {
        $("#searchResult").text("");
       // console.log(posts);
        let divSearchResult = $("#searchResult");
        let pTitle, pBody, hiddenPostId, btnComments ;

        $.each(posts, function (index, post) {
            var divPost = $("<div>");
            pTitle = $("<p>").text(post.title);
            pBody= $("<p>").text(post.body);
            hiddenPostId = $("<input>").prop("type", "hidden").val(post.id);

            pTitle.appendTo(divPost);
            pBody.appendTo(divPost);
            hiddenPostId.appendTo(divPost);

            btnComments = $("<input>").prop("value", "Show Comments")
                .prop("type", "button");
            btnComments.appendTo(divPost);
            //btnComments.click(commentsFunc);
            btnComments.on( "click", function(evt) {
                var postId = $(this).siblings(":hidden").val();
                $.get(URL + COMMENTS_BY_POST + postId)
                    .done(function(comments){
                        commentsSuccess(divPost, comments);
                    })
                    .fail(ajaxError);
                evt.stopImmediatePropagation();
            });


            divPost.appendTo(divSearchResult);


            divPost.addClass("divPost");
            btnComments.addClass("btnComments");
        })
    }

   /* function commentsFunc(event) {
        var postId = $(this).siblings(":hidden").val();
        $.get(URL + COMMENTS_BY_POST + postId)
            .done(function(divPost, comments){
                commentsSuccess(divPost, comments);
            })
            .fail(ajaxError);
        event.stopImmediatePropagation();
    }*/

    function commentsSuccess(divPost, comments) {
        let divComments, pNameComments, pEmailComments, pBodyComments;
        $(".divComments").remove();
        $.each(comments, function(index, comment) {
            //console.log(comment);
            divComments = $("<div>");
            pNameComments = $("<p>").text(comment.name);
            pEmailComments = $("<p>").text(comment.email);
            pBodyComments = $("<p>").text(comment.body);

            pEmailComments.appendTo(divComments);
            pNameComments.appendTo(divComments);
            pBodyComments.appendTo(divComments);

            divComments.appendTo(divPost);

            // setup css
            divComments.addClass("divComments");
        });
    }
    function ajaxError(xhr, status, exception) {
        console.log(xhr, status, exception);
    }
});