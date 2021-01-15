<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/12/1
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <center>
        <p>登录成功</p>
        <%
            Cookie[] cookies = request.getCookies();
            Cookie cookie = null;
            Cookie cookie1 = null;
        %>

        <%--显示当期用户名--%>
        <strong>当前登录用户：</strong>
        <%

            for(int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("username")) {
                    cookie = cookies[i];
                    String user = cookie.getValue();
                    out.print(user);
                }
            }
        %>
        <br/>

        当前登录时间：
        <%out.print(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));%>
        <br/>

        上次的登录时间是：
        <%
            for(int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("visitTime")) {
                    cookie = cookies[i];
                    Long time = Long.parseLong(cookie.getValue());
                    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    out.print(df.format(time));
                }
            }
        %>
        <br/>

        访问次数：
        <%
            for(int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("number")) {
                    cookie1 = cookies[i];
                    Integer time = Integer.parseInt(cookie1.getValue());
                    int temp = time + 1;
                    out.print(time);
                    Cookie newTime = new Cookie("number", "" + temp);
                    newTime.setMaxAge(60 * 60 * 24 * 14);
                    //newTime.setPath("/");
                    response.addCookie(newTime);
                }
            }
        %>

    </center>

</body>
</html>
