<%-- 
    Document   : Choose
    Created on : Mar 10, 2016, 1:32:59 PM
    Author     : SOKLY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Choose</title>
    </head>
    <body>
        <form method='post' action='ChooseServlet'>
            <p>Is JSP cool?</p>
            <input type='radio' value='1' name='radioJSPCool' ${radioCheckList[0].yesCheck}><span>Yes</span><br/>
            <input type='radio' value='0' name='radioJSPCool' ${radioCheckList[0].noCheck}><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <p>Is JSF way cool?</p>
            <input type='radio' value='1' name='JSFwayCool' ${radioCheckList[1].yesCheck}><span>Yes</span><br/>
            <input type='radio' value='0' name='JSFwayCool' ${radioCheckList[1].noCheck}><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>
            <p>Is the moon made of cheese?</p>
            <input type='radio' value='1' name='moonCheese' ${radioCheckList[2].yesCheck}><span>Yes</span><br/>
            <input type='radio' value='0' name='moonCheese' ${radioCheckList[2].noCheck}><span>No</span><br/>
            <input type='submit' name='btnSubmit' value='Submit'/>

        </form>
    </body>
</html>
