<%--
  Created by IntelliJ IDEA.
  User: Vino
  Date: 2022/5/3
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发个贴子</title>
</head>
<body>
<h1>发贴</h1>
<form action="/myWeb_war/postAddServlet" method="post">
    <label for="title">主题</label><input id="title" type="text" name="title"><br>
    <label for="content">正文</label><br>
    <textarea id="content" name="content" cols="20" rows="5"></textarea><br>
    <input type="submit" value="点击发贴">
</form>
</body>
</html>
