<%@ page import="com.liu.entity.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/7
  Time: 22:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //创建一个Student类型的对象
    Student student = new Student(10,"mike");
    List list = new ArrayList();
%>

学员编号：<%=student.getSid()%><br/>
学院姓名：<%=student.getSname()%>
