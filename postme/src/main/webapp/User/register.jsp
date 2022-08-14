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
    <title>注册界面</title>
    <style>
        span{
            color: #e50000;
        }
    </style>
</head>

<body>
<h1>注册</h1>
<form id="inputInfo" method="post" action="/myWeb_war/registerServlet">
    <p><h1>Register</h1><div id="errMsg"><span>${errMsg}</span></div></p>
    <p><label for="username">用户名称</label><input id="username" name="username" type="text">
        <span id="username_err" class="err_mesg" style="display: none">用户名格式有误</span></p>
    <p><label for="password">用户密码</label><input id="password" name="password" type="password">
        <span id="password_err" class="err_mesg" style="display: none">密码不符合要求</span></p>
    <p><input type="radio" name="gender" value="1" checked>男
        <input type="radio" name="gender" value="0">女</p>
    <p><label for="telephone">手机号码</label><input id="telephone" type="text" name="telephone">
        <span id="telephone_err" class="err_mesg" style="display: none">输入的手机号不存在</span></p>
    <div id="subDiv">
        <input type="submit" value="注册">
        <input type="reset" value="清空">
    </div>
</form>
<a href="./login.jsp">已有账号？</a>

<script>
    var usernameInput = document.getElementById("username");
    usernameInput.onclick = function (){
        document.getElementById("username_err").style.display = 'none';
    }
    usernameInput.onblur = checkUsername;
    function checkUsername(){
        var username = usernameInput.value.trim();
        var usernameReg = /^[A-Za-z]+[0-9]*$/;
        if(usernameReg.test(username)){
            document.getElementById("username_err").style.display = 'none';
            return true;
        }else{
            document.getElementById("username_err").style.display = '';
            return false;
        }
    }

    var passwordInput = document.getElementById("password");
    passwordInput.onclick = function (){
        document.getElementById("password_err").style.display = 'none';
    }
    passwordInput.onblur = checkPassword;
    function checkPassword(){
        var password = passwordInput.value.trim();
        if(password.length >=6 && password.length <=16){
            document.getElementById("password_err").style.display = 'none';
            return true;
        }else{
            document.getElementById("password_err").style.display = '';
            return false;
        }
    }

    var telephoneInput = document.getElementById("telephone");
    telephoneInput.onclick = function (){
        document.getElementById("telephone_err").style.display = 'none';
    }
    telephoneInput.onblur = checkTel;
    function checkTel(){
        var telephone = telephoneInput.value.trim();
        var telephoneReg = /^1[0-9]{10}$/;
        if(telephone.match(telephoneReg)){
            document.getElementById("telephone_err").style.display = 'none';
            return true;
        }else{
            document.getElementById("telephone_err").style.display = '';
            return false;
        }
    }

    document.getElementById("inputInfo").onsubmit = function (){
        return checkUsername() && checkPassword() && checkTel();
    }
</script>
</body>
</html>
