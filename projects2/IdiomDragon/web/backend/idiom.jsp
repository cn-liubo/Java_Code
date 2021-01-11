<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/12/4
  Time: 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>显示界面</title>
</head>
<body>
<div align="center">
    <form action="/myWeb/backend/idiomDragon.jsp" method="post">
        <h1>欢迎来到成语接龙</h1>
        <h2>当前成语的进度为：</h2>
        <%
            String s=(String)session.getAttribute("mes");
            if(s!=null){
                out.println(s);
            }
            else{
                out.println("暂时没有成语，请重新输入");
            }
        %>
        <br/>
        输入成语：<input type="text" name="idiom"/><br/>
        <input type="submit" value="提交"/>
    </form>
</div>
</body>
</html>
