<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/7
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    JSP文件内置对象：request
               类型：HTTPServletRequest
               作用：在JSP文件运行时读取请求包信息
                     与Servlet在请求转发过程中实现数据共享

    浏览器：http://localhost:8080/myWeb/request.jsp?username=allen&password=123
-->
<%
    //在JSP文件执行时，借助于内置对象request对象读取请求包参数信息
    String usrname = request.getParameter("username");
    String password = request.getParameter("password");
%>
来访用户姓名：<%=usrname%><br/>
来访用户密码：<%=password%>

