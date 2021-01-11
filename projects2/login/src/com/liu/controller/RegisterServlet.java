package com.liu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.setCharacterEncoding("UTF-8");
        //获得用户提交的数据
        String name = request.getParameter("name");
        String psw1 = request.getParameter("psw1");
        String psw2 = request.getParameter("psw2");
        String sex = request.getParameter("sex");
        String []fav = request.getParameterValues("favorite");
        String mesg = request.getParameter("mesg");
        if (psw1.equals(psw2)){
            //把消息放进session中
            HttpSession session = request.getSession();
            session.setAttribute("name",name);
            session.setAttribute("psw1",psw1);
            session.setAttribute("sex",sex);
            session.setAttribute("favorite", Arrays.toString(fav));
            session.setAttribute("mesg",mesg);
            //重定向
            response.sendRedirect("success.jsp");
        }
//        else {
//            request.getSession().setAttribute("passwordError","yes");
//            response.sendRedirect("register.jsp");
//        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
