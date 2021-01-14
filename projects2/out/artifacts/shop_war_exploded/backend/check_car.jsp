<%@ page import="com.liu.dao.BookDao" %>
<%@ page import="com.liu.entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liu.entity.BuyBook" %><%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/15
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body{
            text-align: center;
            margin-top: 100px;
            background-size:cover;
        }
    </style>
</head>
<body>

    <table border="2" align="center">
        <tr>
            <td>书籍编号</td>
            <td>书籍名称</td>
            <td>总价格</td>
            <td>书籍数目</td>
        </tr>

        <%
            BookDao dao = new BookDao();
            List<BuyBook> bookList = dao.check();

        %>
        <%
            for(int i = 0; i < bookList.size(); i++) {
        %>
        <tr>
            <td><%=bookList.get(i).getId()%></td>
            <td><%=bookList.get(i).getBookName()%></td>
            <td><%=bookList.get(i).getTotalPrice()%></td>
            <td><%=bookList.get(i).getNumber()%></td>
        </tr>
        <%
            }
        %>
    </table>
    <br/>
    <a href="/myWeb/backend/book.jsp">继续添加</a>
    <br/>
    <a href="">结算</a>

</body>
</html>
