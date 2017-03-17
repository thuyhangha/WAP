<%-- 
    Document   : result
    Created on : Mar 8, 2016, 4:50:15 PM
    Author     : SOKLY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beer Recommendation</title>
    </head>
    <body>
        <h1 align="center">Beer Recommendations JSP</h1>
        <p>
            <%
                List styles = (List)request.getAttribute("styles");
                Iterator it = styles.iterator();
                while(it.hasNext()){
                    out.print("<br>try: "+it.next());
                }
            %>
        </p>
    </body>
</html>
