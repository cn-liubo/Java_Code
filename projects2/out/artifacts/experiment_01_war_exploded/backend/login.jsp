<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/8
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <center>
        <font style="color: red; font-size: 30px">登录界面</font>
        <form action="/myWeb/login" method="post">
            <table border="2">
                <tr>
                    <td>登录名</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="登录"/></td>
                    <td><input type="reset"></td>
                </tr>
            </table>
        </form>

    </center>
</body>
</html>
