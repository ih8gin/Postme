<%--
  Created by IntelliJ IDEA.
  User: Vino
  Date: 2022/5/3
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>评论</title>
</head>
<body>
<h1>评论主题帖</h1>
<div>
    ${post.username}<br>
    ${post.title}<br>
    ${post.content}<br>
    <input type="button" value="点赞">${post.likeNum}<br>
</div>
<div>
    <form action="/myWeb_war/commentAddServlet" method="post">
        <input type="hidden" name="pid" value="${post.pid}">
        <textarea name="content" cols="20" rows="5"></textarea><br>
        <input type="submit" name="submit" value="评论">
        <input type="reset" name="reset" value="清空">
    </form>
</div>
</body>
</html>
