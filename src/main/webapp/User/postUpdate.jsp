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
    <title>编辑贴子</title>
</head>
<body>
<h1>修改贴子内容</h1>
<form action="/myWeb_war/postUpdateServlet" method="post" >
    <table>
        <input type="hidden" name="pid" value="${post.pid}">
        <tr>
            <td>主题</td>
            <td><input type="text" name="title" value="${post.title}" ></td>
        </tr>
        <tr>
            <td>正文</td>
            <td><textarea name="content" cols="20" rows="5" >${post.content}</textarea></td>
        </tr>
        <tr>
            <td>状态</td>
            <td><input type="radio" name="status" value="1" id="可见" checked>可见
                <input type="radio" name="status" value="0" id="隐藏">隐藏</td>
            <c:if test="${post.status ==0}">
                <script>
                    document.getElementById("隐藏").checked=true
                </script>
            </c:if>
        </tr>
        <tr>
            <td><input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</body>
</html>
