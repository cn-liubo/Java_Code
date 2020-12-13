package com.liu.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OneServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username, money;
        //1.调用请求对象读取【请求头】参数信息
        username = request.getParameter("username");
        money = request.getParameter("money");
        //2.开卡
        Cookie card1 = new Cookie("username", username);
        Cookie card2 = new Cookie("money", money);
        //3.指定Cookie的card2在客户端硬盘上存活2分钟
        card2.setMaxAge(120);
        //4.发卡，将Cookie写入到响应头中交给浏览器
        response.addCookie(card1);
        response.addCookie(card2);
        //5.通知Tomcat将【点餐页面】内容写入到响应体交给浏览器（请求转发）
        RequestDispatcher report = request.getRequestDispatcher("/index_2.html");
        report.forward(request, response);

    }
}
