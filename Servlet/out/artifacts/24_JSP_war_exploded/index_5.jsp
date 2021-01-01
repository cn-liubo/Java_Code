<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/7
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int age = 15;
%>
<%
    if(age >= 18) {
%>
    <font style="color: red;font-size: 45px">热烈欢迎</font>
<%
    }else {
%>
    <font style="color: red;font-size: 45px">谢绝入内</font>
<%
    }
%>
<!--
    在java中是这样写的
    {
        int age = 15;
        if(age >= 18){
            out.print("<font style="color: red;font-size: 45px">热烈欢迎</font>");
        }else {
            out.print("<font style="color: red;font-size: 45px">谢绝入内</font>");
        }
    }
-->