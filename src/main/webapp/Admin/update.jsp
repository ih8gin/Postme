<%--
  Created by IntelliJ IDEA.
  User: Vino
  Date: 2022/5/3
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>更改用户信息</title>
</head>
<body>
<h1>修改此用户信息</h1>
<form action="/myWeb_war/userUpdateServlet" method="get">
    <table>
        <input type="hidden" name="uid" value="${user.uid}">
        <tr>
            <th>用户名</th>
            <td><input type="text" name="username" value="${user.username}" disabled></td>
        </tr>
        <tr>
            <th>昵称</th>
            <td><input type="text" name="subName" value="${user.subName}"></td>
        </tr>
        <tr>
            <th>用户密码</th>
            <td><input type="text" name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <th>状态</th>
            <td><input type="radio" name="status" value="1" id="可见" checked><label for="可见">正常</label>
                <input type="radio" name="status" value="0" id="隐藏"><label for="隐藏">封禁</label></td>
            <c:if test="${user.status ==0}">
                <script>
                    document.getElementById("隐藏").checked=true
                </script>
            </c:if>
        </tr>
    </table>
    <input type="submit" value="点击提交">
</form>
</body>
</html>
