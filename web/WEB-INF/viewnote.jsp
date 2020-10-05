<%-- 
    Document   : viewnote
    Created on : Sep 30, 2020, 2:20:53 PM
    Author     : 798382
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h3>View Note</h3>
        <h4>Title:${note.title} </h4>
        <br>
        <h4>Contents:${note.content}</h4>
        <br>
        <a href="note?edit">Edit</a> 
    </body>
</html>
    