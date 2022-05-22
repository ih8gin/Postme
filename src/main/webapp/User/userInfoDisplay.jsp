<%--
  Created by IntelliJ IDEA.
  User: Vino
  Date: 2022/5/3
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
<h1>我的主页</h1>
<div>
    <table>
        <tr>
            <th>昵称</th>
            <td>${user.subName}</td>
        </tr>
        <tr>
            <th>性别</th>
            <td><c:if test="${user.gender == 1}">
                    男
                </c:if>
                <c:if test="${user.gender == 0}">
                    女
                </c:if></td>
        </tr>
        <tr>
            <th>年龄</th>
            <td>${user.age}</td>
        </tr>
        <tr>
            <th>电话</th>
            <td>${user.telephone}</td>
        </tr>
        <tr>
            <th>描述</th>
            <td>${user.description}</td>
        </tr>
        <tr>
            <th>注册时间</th>
            <td>${user.regDate}</td>
        </tr>
    </table>
</div>
<div>
    <input type="button" id="updateInfo" class="ownerOnly" value="修改个人信息" style="display: none">
</div>
<div>
    <h2>我的发贴</h2>
    <table>
        <tr>
            <th>发布日期</th>
            <th>主题</th>
            <th>访问量</th>
            <th>回复数</th>
            <th>点赞数</th>
            <th class="ownerOnly" style="display: none">状态</th>
            <th></th>
        </tr>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td>${post.postTime}</td>
                <td>${post.title}</td>
                <td>${post.visitNum}</td>
                <td>${post.replyNum}</td>
                <td>${post.likeNum}</td>
                <c:if test="${post.status == 1}">
                    <td class="ownerOnly" style="display: none">可见</td>
                </c:if>
                <c:if test="${post.status == 0}">
                    <td class="ownerOnly" style="display: none">隐藏</td>
                </c:if>
                <td><a href="/myWeb_war/postSelectForDisplayServlet?pid=${post.pid}">查看</a>
                    <a href="./postSelectForUpdateServlet?pid=${post.pid}" class="ownerOnly" style="display: none">修改</a>
                    <a href="./postDeleteServlet?pid=${post.pid}" class="ownerOnly" style="display: none">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
    if(${visitor} == ${user.uid}){
        for (let x of document.getElementsByClassName("ownerOnly")) {
            x.style.display = ""
        }
    }

    document.getElementById("updateInfo").onclick = function (){
        location.href = "/myWeb_war/userInfoSelectForUpdateServlet?uid=${user.uid}"
    }
</script>
</body>
</html>
