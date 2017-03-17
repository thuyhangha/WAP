<%-- 
    Document   : index
    Created on : Mar 10, 2016, 8:51:05 PM
    Author     : SOKLY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Number Quiz</title>
    </head>
    <body>
        <form method="POST" action="NumberQuiz">
            <h3>Have fun with NumberQuiz!</h3>
            <p>Your current score is: ${quiz.currentScore}</p>
            <p>Attempt ${quiz.countNumAttempt} / 3</p>
            <p>Guess the next number in the sequence! ${quiz.currentQuestion}</p>
            <p>Your answer:<input type='text' name='txtAnswer' value='' /></p>
            <p style='color:red'>${errorMessage}</p>
            <p><input type='submit' name='btnNext' value='Next' />
                <input type='submit' name='btnRestart' value='Restart!' />
                <input type='button' name='btnHint' value='Hint?' onclick='alert("${quiz.hint}")' />
            </p>
        </form>
    </body>
</html>
