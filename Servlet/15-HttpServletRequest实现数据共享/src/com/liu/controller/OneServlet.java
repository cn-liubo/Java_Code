package com.liu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "OneServlet", urlPatterns = "/one")
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //将数据添加到请求作用域对象，作为共享数据
        request.setAttribute("key1", "Hello World");
        //        //2.代替浏览器，向Tomcat索要TwoServlet来完成剩余任务
        request.getRequestDispatcher("/two").forward(request, response);
    }
}
