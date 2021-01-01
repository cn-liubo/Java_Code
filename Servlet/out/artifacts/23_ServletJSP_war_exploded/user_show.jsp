<%@ page import="java.util.List" %>
<%@ page import="com.liu.entity.Student" %>
<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/8
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //从请求作用域对象中得到OneServlet添加进去的集合
    List<Student> list = (List) request.getAttribute("key");
%>

<!--将处理结果写入到响应体中-->
<table border="2" align="center">
    <tr>
        <td>用户编号</td>
        <td>用户姓名</td>
    </tr>
    <%
        for(Student student : list) {
    %>
    <tr>
        <td><%=student.getSid()%></td>
        <td><%=student.getSname()%></td>
    </tr>
    <%
        }
    %>
</table>
