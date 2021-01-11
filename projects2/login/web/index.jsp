<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/8
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>注册</title>
        <h1 style="color: red">注册</h1>
        <style >
            body{
                text-align: center;
                margin-top: 100px;
                background-size:cover;
            }
        </style>

    </head>
    <body>
        <form action="/myWeb/register " method="post">

            用户名：
            <input type="text" name="name"></br></br>

            密&ensp;码：
            <input type="password" name="psw1"></br></br>
            密码确认：
            <input type="password" name="psw2"></br></br>

            性别：
            <input type="radio" name="sex" value="man" checked> 男
            <input type="radio" name="sex" value="woman" checked> 女</br></br>


            爱好：</br>
            <input type="checkbox" name="favorite" value="运动"> 运动 &nbsp;
            <input type="checkbox" name="favorite" value="音乐"> 音乐 &nbsp;</br>
            <input type="checkbox" name="favorite" value="旅游"> 旅游 &nbsp;
            <input type="checkbox" name="favorite" value="健身"> 健身 &nbsp;</br>
            <input type="checkbox" name="favorite" value="家居"> 家居 &nbsp;
            <input type="checkbox" name="favorite" value="美食"> 美食 &nbsp;</br></br>


            简介：</br>
            <textarea name="mesg"></textarea></br></br>

            <input type="submit" value="提交">
            <input type="reset" value="重置">


        </form>
    </body>
</html>
