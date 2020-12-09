package com.liu.controller;

import com.liu.dao.UserDao;
import com.liu.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username, password, sex, email;
        UserDao dao = new UserDao();
        Users user = null;
        int result = 0;
        PrintWriter out = null;

        //1.【调用请求对象】，读取【请求头】里的参数信息，得到用户的注册信息
        username = request.getParameter("username");
        password = request.getParameter("password");
        sex = request.getParameter("sex");
        email = request.getParameter("email");
        //2.【调用UserDao】将用户信息填充到insert命令并借助JBDC规范发送到数据库服务器中
        user = new Users(null, username, password, sex, email);
        result = dao.add(user);
        //3.【调用响应对象】将处理结果以二进制形式写到响应体中
        response.setContentType("text/html;charset=utf-8");//设置响应头content-type属性
        out = response.getWriter();
        if(result == 1) {
            out.print("<font style='color:red;font-size:40'>用户信息注册成功</font>");
        }else {
            out.print("<font style='color:red;font-size:40'>用户信息注册失败</font>");
        }
    }
    //Tomcat负责销毁【请求对象】和【响应对象】
    //Tomcat负责将Http响应协议包推送到发起请求的浏览器上
    //浏览器将响应头中content-type指定编译器对响应体中二进制内容编辑
    //浏览器将编辑后的结果展示给用户【结束】
}
