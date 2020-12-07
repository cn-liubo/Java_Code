package com.liu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {


//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String result = "Hello World";//执行结果


        //-----通过响应对象将结果写入到响应体中-----start

        //1.通过响应对象，向Tomcat索要输出流
        PrintWriter out = response.getWriter();
        //2.通过输出流，将执行结果以二进制形式写入到响应体中
        out.write(result);

        //-----通过响应对象将结果写入到响应体中-----start
    }//doGet执行完毕
    //Tomcat将响应包推送给浏览器
}
