<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/10
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物界面</title>
    <style>
        body{
            text-align: center;
            margin-top: 100px;
            background-size:cover;
        }
    </style>
</head>
<body>

<a href="/myWeb/backend/book.jsp">书籍</a>
<br/>

登录时间是：
<%
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String time = sdf.format(date);
    out.print(time);
%>
<br/>
上次登录时间是：
<%
    //获取客户端所有cookie
    Cookie[] cookies = request.getCookies();
    Cookie cookie = null;
    for (int i = 0; i < cookies.length; i++){
        if (cookies[i].getName().equals("visitTime")){
            cookie = cookies[i];
            Long.parseLong(cookie.getValue());
            long time1 = Long.parseLong(cookie.getValue());
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time2 = df.format(time1);
            out.print(time2);
        }
    }
%>
<br/>
访问次数：
<%
    for (int i = 0 ; i < cookies.length ; i++){
        if (cookies[i].getName().equals("number")){
            cookie = cookies[i];
            Integer time3 = Integer.parseInt(cookie.getValue());
            int temp = time3 + 1;
            out.print(time3);
            Cookie newTime = new Cookie("number", "" + temp);
            newTime.setMaxAge(60 * 60 * 24 * 14);
            newTime.setPath("/");
            response.addCookie(newTime);
        }
    }
%>
<br/>

</body>
</html>
