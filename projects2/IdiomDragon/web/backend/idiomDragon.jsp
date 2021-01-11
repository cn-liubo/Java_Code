<%--
  Created by IntelliJ IDEA.
  User: 39458
  Date: 2020/12/4
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>成语接龙</title>
</head>
<body>
<!--
逻辑上的错误是遇到的最大的问题
 -->
<%!
    String mes="";
%>
<%
    request.setCharacterEncoding("UTF-8");
    String idiom=request.getParameter("idiom");

    //判断长度是否合格
    if(idiom.length()!=4)
    {
        out.println("成语的长度应该为4个字<br/>");
        out.println("<a href='idiom.jsp'>返回重新输入</a>");
    }

    else
    {//1

        //判断是否为成语库（一个txt文件）中的成语，如果不是请重新输入
        boolean isIdiom=false;
        BufferedReader br=null;		//BufferedReader缓冲字符输入流
        try{
            //引入存有成语的txt文件
            br=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\test\\resources\\idiom.txt"),"UTF-8"));
            //使用BufferedReader的readLine()方法可以逐行读取文件的内容
            String connection=br.readLine();
            while(connection!=null){
                if(connection.contains(idiom)){
                    out.println(idiom);
                    isIdiom=true;
                    break;
                }
                connection=br.readLine();
            }
        }catch(IOException e){
            //打印输出异常
            e.printStackTrace();
        }

        if(isIdiom==false)
        {
            out.println("你输入的不是成语库中的成语<br/>");
            out.println("<a href='/myWeb/backend/idiom.jsp'>返回重新输入</a>");
        }
        else
        {//2
            //当满足库中函数的条件时，判断是不是第一个成语，如果不是第一个就判断成语是否接龙
            if(!mes.equals(""))
            {//3
                //charAt()方法 返回 指定索引处的 char值
                if( mes.charAt(mes.length()-3) != idiom.charAt(0) )
                {
                    out.println("请注意成语接龙规则：后一个成语的第一个字必须是前一个成语的最后一个字<br/>");
                    out.println("<a href='/myWeb/backend/idiom.jsp'>返回重新输入</a>");
                }
                else
                {
                    mes+=idiom+">>";
                    session.setAttribute("mes",mes);
                    out.println("<br/>成语已经提交成功，四秒后自动跳转查看成语");
                    response.setHeader("refresh","4;idiom.jsp");
                }

            }//3
            else
            {//4
                mes+=idiom+">>";
                session.setAttribute("mes",mes);
                out.println("<br/>成语已经提交成功，四秒后自动跳转查看成语");
                response.setHeader("refresh","4;idiom.jsp");
            }//4

        }//2

    }//1

%>
</body>
</html>
