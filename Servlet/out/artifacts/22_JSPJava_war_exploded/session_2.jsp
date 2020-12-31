<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/7
  Time: 23:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    session_1.jsp 与session_2,jsp为同一个用户/浏览器提供服务，
    因此可以使用当前用户在服务端的私人储物柜进行数据共享
-->
<%
    Integer value = (Integer) session.getAttribute("key1");
%>
session_2.jsp从当前用户session中读取数据：<%=value%>

