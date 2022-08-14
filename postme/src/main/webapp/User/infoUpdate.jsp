<%--
  Created by IntelliJ IDEA.
  User: Vino
  Date: 2022/5/3
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改个人信息</title>
</head>
<body>
<h1>编辑个人信息</h1>
<form action="/myWeb_war/infoUpdateServlet" method="post" >
    <table>
        <input type="hidden" name="uid" value="${user.uid}">
        <tr>
            <td>用户名</td>
            <td>${user.username}</td>
        </tr>
        <tr>
            <td>昵称</td>
            <td><input type="text" name="subName" value="${user.subName}" ></td>
        </tr>
        <tr>
            <td>性别</td>
            <td><input type="radio" name="gender" value="1" id="male" checked><label for="male">男</label>
                <input type="radio" name="gender" value="0" id="female"><label for="female">女</label></td>
            <c:if test="${user.gender ==0}">
                <script>
                    document.getElementById("female").checked=true
                </script>
            </c:if>
        </tr>
        <tr>
            <td>年龄</td>
            <td><input type="text" name="age" value="${user.age}" ></td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="telephone" value="${user.telephone}" ></td>
        </tr>
        <tr>
            <td>描述</td>
            <td><textarea name="description" cols="20" rows="5" >${user.description}</textarea></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="text" name="password" value="${user.password}" ></td>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
