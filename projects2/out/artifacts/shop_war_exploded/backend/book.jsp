<%@ page import="java.util.List" %>
<%@ page import="com.liu.entity.Book" %>
<%@ page import="com.liu.dao.BookDao" %>
<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/14
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍</title>
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
            <td>书籍价格</td>
            <td>书籍数目</td>
            <td>操作</td>
        </tr>

       <%
           BookDao dao = new BookDao();
           List<Book> bookList = dao.find();
           for(Book book : bookList) {
       %>
        <tr>
            <td><%=book.getId()%></td>
            <td><%=book.getBookName()%></td>
            <td><%=book.getPrice()%></td>
            <td><%=book.getNumber()%></td>
            <td><a href='/myWeb/add?bookId=<%=book.getId()%>'>加入购物车</a></td>
            <%
                }
            %>
        </tr>
    </table>
</body>
</html>
