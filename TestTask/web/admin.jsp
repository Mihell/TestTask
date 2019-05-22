<%--
  Created by IntelliJ IDEA.
  User: Михаил
  Date: 22.05.2019
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<body>
    <h1>Admin cabinet</h1>
    <form action="/change">
        Name: <input type="text" name="name"><br>
        Description: <input type="text" name="description"><br>
        Price: <input type="text" name="price"><br>
        <input type="submit" value="add new product">
    </form>

    <br><br>
    <form action="/change">
        ID of product which need to be removed: <input type="text" name="id"><br>
        <input type="submit" value="remove product">
    </form>

    <form action="/change" method="post">
        ID of product which need to be edited: <input type="text" name="id"><br>
        New name(optional): <input type="text" name="name"><br>
        New description(optional): <input type="text" name="description"><br>
        New price(optional): <input type="text" name="price"><br>
        <input type="submit" value="edit product">
    </form>

    <a href="/index.jsp">To main menu</a>
</body>
</html>
