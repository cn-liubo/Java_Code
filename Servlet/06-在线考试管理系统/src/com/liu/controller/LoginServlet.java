package com.liu.controller;

import com.liu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username, password;
        UserDao dao = new UserDao();
        int result = 0;
        //1.调用请求对象对请求体使用utf-8字符集进行重新编辑
        request.setCharacterEncoding("utf-8");
        //2.调用请求对象读取请求体中参数信息
        username = request.getParameter("username");
        password = request.getParameter("password");
        //3.调用Dao将查询验证信息推送到数据库服务器上
        result = dao.login(username, password);
        //4.调用响应对象，根据验证结果将不同资源文件地址写入到响应头，交给浏览器
        if(result == 1) {//用户存在
            //再判断来访用户身份合法后，通过请求对象向Tomcat申请为当前用户申请一个HttpSession
            HttpSession session = request.getSession();
            response.sendRedirect("/myWeb/index.html");
        }else {
            response.sendRedirect("/myWeb/login_error.html");
        }

    }

}
