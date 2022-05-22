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
<h1>查看一个贴子下的一条评论，及其下所有回复</h1>
<div>
    <b>发贴用户：</b>${post.username}<br>
    <b>发贴标题：</b>${post.title}<br>
    <b>发贴内容：</b>${post.content}<br>
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
    <b>评论用户：</b>${comment.username}<br>
    <b>评论内容：</b>${comment.content}<br>
    <table>
        <tr>
            <td>点赞${comment.likeNum}</td>
            <td>回复${comment.replyNum}</td>
            <td><a href="/myWeb_war/commentSelectForReplyServlet?pid=${comment.pid}&cid=${comment.cid}">点击回复这条评论</a></td>
        </tr>
    </table>
    <hr>
</div>
<c:forEach items="${replies}" var="reply">
    <b>回复用户：</b>${reply.username}<br>
    <b>回复内容：</b>${reply.content}<br>
    <table>
        <tr>
            <td>点赞${reply.likeNum}</td>
            <td><a href="/myWeb_war/replySelectForReplyServlet?pid=${reply.pid}&cid=${reply.cid}&rid=${reply.rid}">点击回复这条回复</a></td>
        </tr>
    </table>
    <hr>
</c:forEach>
</body>
</html>
