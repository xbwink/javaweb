<%--
  Created by IntelliJ IDEA.
  User: xb
  Date: 2022/11/17
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="css/login.css" rel="stylesheet">
</head>

<body>
<div id="loginDiv" style="height: 350px">
    <form action="/brand_demo/loginServlet" id="form" method="post">
        <h1 id="loginMsg">LOGIN IN</h1>
        <div id="errorMsg">${errorMsg}</div>
        <p>Username:<input id="username" name="username" type="text" value="${cookie.nameCookie.value}"></p>

        <p>Password:<input id="password" name="password" type="password" value="${cookie.pwdCookie.value}"></p>
        <p>Remember:<input id="remember" name="remember" type="checkbox"></p>
        <div id="subDiv">
            <input type="submit" class="button" value="login up">
            <input type="reset" class="button" value="reset">&nbsp;&nbsp;&nbsp;
            <a href="/brand_demo/register.jsp">没有账号？</a>
        </div>
    </form>
</div>

</body>
</html>