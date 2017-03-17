<%-- 
    Document   : table
    Created on : Mar 12, 2016, 11:31:03 AM
    Author     : SOKLY
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='cs472' uri='/WEB-INF/tlds/myForEach' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <table>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Lecture 5</title>
        </head>
        <body>
            <table>

                <cs472:my4each var="student" items="${students}">
                    <tr>
                        <td>${student.name}</td>
                        <td>${student.age}</td>
                    </tr>
                </cs472:my4each>

            </table>
        </body>
</html>