<%-- 
    Document   : quizOver
    Created on : Mar 10, 2016, 9:00:39 PM
    Author     : SOKLY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NumberQuiz is over</title>
    </head>
    <body>
        <form action='NumberQuiz' method='post'>
		<h3>Game Over</h3>
		<p>Your current score is ${quiz.currentScore}.</p>
                 <p>Your Grade is <font style='color:red'><h3>${quiz.showGrade}</h3></font></p>
		<p><input type='submit' name='btnRestart' value='Start Over!' /></p>                
	</form>
    </body>
</html>
