<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/10
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
    <center>
        <font style="color: red; font-size: 30px">注册界面</font>
        <form action="/myWeb/register" method="post">
            <table border="2">
                <tr>
                    <td>用户名</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>密码</td>
                    <td><input type="password" name="rgpassword"/></td>
                </tr>
                <tr>
                    <td>确认密码</td>
                    <td><input type="password" name="brpassword"/></td>
                </tr>
                <tr>
                    <td>性别</td>
                    <td>
                        <input type="radio" name="sex" value="男"/>男
                        <input type="radio" name="sex" value="女"/>女
                    </td>
                </tr>
                <tr>
                    <td>邮箱</td>
                    <td><input type="text" name="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="注册"/></td>
                    <td><input type="reset"></td>
                </tr>
            </table>
        </form>

    </center>
</body>
</html>
