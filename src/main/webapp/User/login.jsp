<%--
  Created by IntelliJ IDEA.
  User: Vino
  Date: 2022/5/3
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>登录界面</title>
    <style>
        span{
            color: #e50000;
        }
    </style>
</head>
<body>
<h1>登陆</h1>
<form method="post" action="/myWeb_war/loginServlet">
    <p><h1>Login</h1><div id="errMsg" class="err_mesg"><span>${errMsg}</span></div></p>
    <p><label for="username">用户名称</label><input id="username" name="username" type="text" value="${cookie.username.value}"></p>
    <p><label for="password">用户密码</label><input id="password" name="password" type="password" value="${cookie.password.value}"></p>
    <p><label for="remember">记住我</label><input id="remember" name="remember" value="1" type="checkbox"></p>
    <div id="subDiv">
        <input type="submit" value="登录">
        <input type="reset" value="清空">
        <a href="./register.jsp">没有账号？</a>
    </div>
</form>
</body>
</html>
