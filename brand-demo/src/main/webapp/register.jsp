<%--
  Created by IntelliJ IDEA.
  User: xb
  Date: 2022/11/17
  Time: 18:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span>已有帐号？</span> <a href="/brand_demo/login.jsp">登录</a>
    </div>
    <form id="reg-form" action="/brand_demo/registerServlet" method="post">

        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                    <br>
                    <span id="username_err" class="err_msg">${errorNameMsg}</span>
                </td>

            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                    <br>
                    <span id="password_err" class="err_msg" style="display: none">密码格式有误</span>
                </td>
            </tr>


            <tr>
                <td>验证码</td>
                <td class="inputs">
                    <input name="checkCode" type="text" id="checkCode">
                    <img src="/brand_demo/checkCodeServlet" id="checkCodeImg">
                    <a href="#" id="changeImg">看不清？</a>
                </td>
            </tr>

        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>
</body>
</html>
<%--引入axios--%>
<script src="js/axios-0.18.0.js"></script>
<script>
    //点击"看不清"刷新验证码图片
    document.getElementById("changeImg").onclick = function () {
        //为避免浏览器缓存因此每次请求携带不同参数(时间)
        document.getElementById("checkCodeImg").src = "/brand_demo/checkCodeServlet?" + new Date().getMilliseconds();
    }

    //点击验证码图片刷新验证码
    document.getElementById("checkCodeImg").onclick = function () {
        this.src = "/brand_demo/checkCodeServlet?" + new Date().getMilliseconds();
    }

    //给用户名输入框绑定失去焦点事件
    document.getElementById("username").onblur = function () {
        //获取用户名输入框值
        var value = this.value;
        if (value == null || value == "") {//非空验证
            return;
        }
        axios({
            method: "get",
            url: "http://localhost:8080/brand_demo/selectByNameServlet?username=" + value
        }).then(function (resp) {
            var msg = document.getElementById("username_err");
            //根据返回值修改页面提示信息
            if (resp.data == true) {
                msg.innerText = "用户名已存在！";
                return;
            }
            msg.innerText = "用户名可用！";
        });

    }


</script>