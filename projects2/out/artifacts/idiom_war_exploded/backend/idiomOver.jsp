<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/12/2
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接力结束页面</title>
</head>
<body>
    <strong>没有查询到符合要求的成语，接力结束</strong><br>
    ${cookie.cookie.value}
    <a href="/idiomJsp/idiom.jsp">返回重新接力</a>
</body>
</html>
