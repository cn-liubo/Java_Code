<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/10
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>失败页面</title>
</head>
<body>
    <center>
        对不起您的用户名不存在或密码错误，请选择重新登录或者注册账号<br/>
        <form action="/myWeb/backend/login.jsp">
            <input type="submit" value="重新登录">
        </form>

        <form action="/myWeb/backend/register.jsp">
            <input type="submit" value="注册">
        </form>
    </center>
</body>
</html>
