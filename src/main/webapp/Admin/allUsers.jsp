<%--
  Created by IntelliJ IDEA.
  User: Vino
  Date: 2022/5/3
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<h1>全部用户信息</h1>
<table>
    <tr>
        <th>用户名</th>
        <th>昵称</th>
        <th>用户密码</th>
        <th>状态</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.username}</td>
            <td>${user.subName}</td>
            <td>${user.password}</td>
            <c:if test="${user.status == 1}">
                <td>正常</td>
            </c:if>
            <c:if test="${user.status == 0}">
                <td>封禁</td>
            </c:if>
            <td><a href="/myWeb_war/userSelectForUpdateServlet?uid=${user.uid}">修改</a>
                <a href="/myWeb_war/userDeleteServlet?uid=${user.uid}">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
