<%-- 
    Document   : editnote
    Created on : Sep 30, 2020, 2:21:09 PM
    Author     : 798382
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        
        <form action="note" method="post">
            Title:<input type="text" name="title" value ="${note.title}"><br>
            Content:<textarea name="content" cols="20" rows="5">${note.content}</textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>
