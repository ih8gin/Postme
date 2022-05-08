<%--
  Created by IntelliJ IDEA.
  User: Vino
  Date: 2022/5/3
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>611贴吧</title>
</head>
<body>
<h1>回复贴子下的一条评论</h1>
<div>
    ${post.username}<br>
    ${post.title}<br>
    ${post.content}<br>
    <table>
        <tr>
            <td>点赞${post.likeNum}</td>
            <td>回复${post.replyNum}</td>
            <td><a href="/myWeb_war/ypostSelectServlet?pid=${post.pid}">点击评论</a></td>
        </tr>
    </table>
    <hr>
</div>
<div>
    ${comment.username}<br>
    ${comment.content}<br>
    <table>
        <tr>
            <td>点赞${comment.likeNum}</td>
            <td>回复${comment.replyNum}</td>
            <td><a href="/myWeb_war/xcommentSelectServlet?cid=${comment.cid}">点击回复</a></td>
        </tr>
    </table>
    <hr>
</div>
<div>
    <form action="/myWeb_war/replyToCommentServlet" method="post">
        <input type="hidden" name="pid" value="${comment.pid}">
        <input type="hidden" name="cid" value="${comment.cid}">
        <label for="content">正文</label><br>
        <textarea id="content" name="content" cols="20" rows="5"></textarea><br>
        <input type="submit" value="点击回复">
    </form>
</div>
</body>
</html>
