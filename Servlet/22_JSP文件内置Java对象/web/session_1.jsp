<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/7
  Time: 23:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    JSP文件内置对象；session
               类型：HTTPSession
               作用：JSP文件在运行时，可以session指向单签用户私人储物柜，添加共享数据或者读取共享数据
-->

<!--将共享数据添加到当前用户私人储物柜-->
<%
    //向Tomcat索要HttpSession session = request.getSession();
    session.setAttribute("key1", 200);
%>