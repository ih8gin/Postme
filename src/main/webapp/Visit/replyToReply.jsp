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
<h1>回复一条回复，并显示其所属贴子、评论及回复</h1>
<div>
    ${post.username}<br>
    ${post.title}<br>
    ${post.content}<br>
    <table>
        <tr>
            <td>点赞${post.likeNum}</td>
            <td>回复${post.replyNum}</td>
<%--            <td><a href="/myWeb_war/postSelectForCommentServlet?pid=${post.pid}">点击评论</a></td>--%>
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
<%--            <td><a href="/myWeb_war/commentSelectForReplyServlet?pid=${comment.pid}&cid=${comment.cid}">点击回复这条评论</a></td>--%>
        </tr>
    </table>
    <hr>
</div>

<div>
    ${reply.username}<br>
    ${reply.content}<br>
    <table>
        <tr>
            <td>点赞${reply.likeNum}</td>
<%--            <td><a href="/myWeb_war/replySelectForReplyServlet?pid=${reply.pid}&cid=${reply.cid}&rid=${reply.rid}">点击回复这条回复</a></td>--%>
        </tr>
    </table>
    <hr>
</div>

<div>
    <form action="/myWeb_war/replyToReplyServlet" method="post">
        <input type="hidden" name="pid" value="${reply.pid}">
        <input type="hidden" name="cid" value="${reply.cid}">
        <input type="hidden" name="rid" value="${reply.rid}">
        <label for="content">正文</label><br>
        <textarea id="content" name="content" cols="20" rows="5"></textarea><br>
        <input type="submit" value="点击回复">
    </form>
</div>
</body>
</html>
