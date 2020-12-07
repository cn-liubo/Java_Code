package com.liu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {

    /*
        问题描述：浏览器收到数据是2，不是50

        问题原因：
                out.write()方法可以将[字符]，[字符串]，[ASCII码]写到响应体中
                ASCII码： 2----50

        解决方案：在实际开发中，都是通过out.print()方法将真实数据写入到响应体中
     */
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int money = 50;//执行结果

        PrintWriter out = resp.getWriter();
        //out.write(money);
        out.println(money);//推荐使用
    }
}
