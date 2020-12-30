<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/11/7
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //在JSP文件中，只有书写在执行标记中的内容才会被当做java命令
    //1.声明java变量
    int num1 = 100;
    int num2 = 200;
    //2.声明运行表达式：数学运算，关系运算，逻辑运算
    int num3 = num1 + num2;//数学运算
    int num4 = num2 >= num1 ? num2 : num1;//关系运算
    boolean num5 = num2 >= 200 && num1 >= 100;//逻辑运算
    //3.声明控制语句
    if(num2 >= num1) {

    }else {

    }

    for(int i = 1; i <= 10; i++) {

    }


%>
