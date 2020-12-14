package com.liu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "TwoServlet", urlPatterns = "/two")
public class TwoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //从同一个请求作用域对象中得到OneServlet写入到共享数据
        String value = (String)request.getAttribute("key1");
        System.out.println("TwoServlet得到的共享数据：" +value);
    }
}
