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
<c:if test="${visitorName != null}">
    <h1>${visitorName},欢迎宁 >_< </h1>
</c:if>
<c:if test="${visitorName == null}">
    <h1>游客，也欢迎宁 >_< </h1>
</c:if>
<a href="/myWeb_war/userInfoSelectForDisplayServlet">我的主页</a><br>
<a href="/myWeb_war/Visit/postWrite.jsp">发个帖子</a>
<h1>贴吧主页</h1>
<c:forEach items="${posts}" var="post">
    <b>发贴用户：</b><h4>${post.username}</h4><br>
    <b>发贴标题：</b><h3>${post.title}</h3>
    <table>
        <tr>
            <td>访问量${post.visitNum}</td>
            <td>点赞${post.likeNum}</td>
            <td>评论${post.replyNum}</td>
            <td><a href="/myWeb_war/postSelectForDisplayServlet?pid=${post.pid}">进入本贴</a></td>
        </tr>
    </table>
    <hr>
</c:forEach>
</body>
</html>
