package com.liu.controller;

import com.liu.dao.UserDao;
import com.liu.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String rgpassword = request.getParameter("rgpassword");
        String brpassword = request.getParameter("brpassword");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        User user = new User(null, username, rgpassword, sex, email);
        //调用UserDao将用户信息填充到INSERT命令并借助JDBC规范发送到数据库服务器
        UserDao dao = new UserDao();
        int result = dao.addUser(user);
        if(result > 0) {
            request.getRequestDispatcher("/backend/register_success.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
