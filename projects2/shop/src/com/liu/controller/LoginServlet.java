package com.liu.controller;

import com.liu.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String keep = request.getParameter("keep");
        String checknumber = request.getParameter("checknumber");
        int number = 1;
        //从session中取出验证码
        String checkcode = (String) request.getSession().getAttribute("checkcode");
        UserDao dao = new UserDao();
        int result = dao.login(username, password);

        if(checkcode.equals(checknumber) && result > 0) {
            if(keep != null) {
                //两周免登录
                Cookie name = new Cookie("username", username);
                name.setMaxAge(60 * 60 * 24 * 14);
                name.setPath("/");
                response.addCookie(name);

                //上次访问时间
                //Cookie time = new Cookie("visitTime", new Long(System.currentTimeMillis()).toString());
                Cookie time = new Cookie("visitTime","" + System.currentTimeMillis());
                time.setMaxAge(60 * 60 * 24 * 14);
                name.setPath("/");
                response.addCookie(time);

                //登录次数
                Cookie times = new Cookie("number", String.valueOf(number));
                times.setMaxAge(60 * 60 * 24 * 14);
                times.setPath("/");
                response.addCookie(times);
            }
            //调用响应对象，根据验证结果将不同资源文件地址写入响应头location属性，交给浏览器
            response.sendRedirect("/myWeb/backend/shopping.jsp");

        }else {
            response.sendRedirect("/myWeb/backend/login_error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
