<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/12/2
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成语接龙展示页面</title>
</head>
<body>
<tr>
    <td>
        <c:forEach var="nextIdiom" items="${nextIdiom}">

<tr>
    <td height="20" bgcolor="#FFFFFF" ><div>${nextIdiom.name}</div></td>
    <form action="/idiom">
        <input type="hidden" name="idiom" value="${nextIdiom.name}">
        <input type="submit" value="继续接力">
    </form>
</tr>
</c:forEach>
</td>
</tr>
</body>
</html>
