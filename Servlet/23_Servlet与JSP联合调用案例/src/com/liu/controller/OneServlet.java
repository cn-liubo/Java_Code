package com.liu.controller;

import com.liu.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OneServlet", urlPatterns = "/one")
public class OneServlet extends HttpServlet {

    //处理业务，得到处理结果----查询学员信息
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Student student1 = new Student(10, "mike");
        Student student2 = new Student(20, "allen");
        List list = new ArrayList();
        list.add(student1);
        list.add(student2);

        //将处理结果添加到请求作用域对象中
        request.setAttribute("key", list);
        //通过请求转发方案，向Tomcat申请调用user_show.jsp
        //同时将request与response通过Tomcat嫁给user_show.jsp使用
        request.getRequestDispatcher("/user_show.jsp").forward(request, response);
    }
}
