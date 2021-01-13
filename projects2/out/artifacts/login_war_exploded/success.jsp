<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/8
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>信息显示</title>

        <style>
            body{
                text-align: center;
                margin-top: 100px;
                background-size:cover;
            }
        </style>

    </head>
    <body>
    <%--通过session得到信息--%>
    <h1 style="color: orangered" >注册成功</h1>
            <p>用户名：${sessionScope.name}</p>
            <p>密码：${sessionScope.psw1}</p>
            <p>性别：${sessionScope.sex}</p>
            <p>爱好：${sessionScope.favorite}</p>
            <p>个人简介：${sessionScope.mesg}</p>
    </body>
</html>
