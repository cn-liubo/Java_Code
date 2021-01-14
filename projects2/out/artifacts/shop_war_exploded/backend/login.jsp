<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/10
  Time: 19:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <style >
        body{
            text-align: center;
            margin-top: 200px;
            background-size:cover;
        }
    </style>
</head>
<body>

    <center>
            <font style="color: red; font-size: 30px">登录界面</font>
            <form action="/myWeb/login" method="post">
                用户名：
                <input type="text" name="username"></br></br>

                密&ensp;码：
                <input type="password" name="password"></br></br>

                验证码：
                <input type="text" name="checknumber">
                <img src="/myWeb/checknumber.png" /> </br></br>

                <input type="checkbox" name="keep" >两周免登陆 </br></br>

                <input type="submit" value="登录">

            </form>

    </center>
</body>
</html>
