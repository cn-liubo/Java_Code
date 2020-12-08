package com.liu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ThreeServlet extends HttpServlet {

    /*
        问题：
            以GET方式发送中文参数内容“老杨是正经人”时，得到一个正常的结果
            以POST方式发送中文参数内容“老崔是个男人”时，得到乱码??????

        原因：
            浏览器以GET方式发送请求时，请求参数保存在[请求头]中，在Http请求协议包在到达Http服务器之后，第一件事就是进行解码
            请求头中的二进制内容由Tomcat负责解码，Tomcat默认使用[UTF-8]字符集，可以解释所有国家的文字

            浏览器以POST方式发送请求时，请求参数保存在[请求体]中，在Http请求协议包在到达Http服务器之后，第一件事就是进行解码
            请求体中的二进制内容由当前请求对象（request）负责解码，request默认使用[ISO-8859-1]字符集，一个东欧语系的字符集
            此时如果请求体参数内容是中文，将无法解码只能得到乱码

        解决方案：
            在POST请求方式下，在读取请求体的内容之前，应该通知请求对象使用UTF-8字符集对请求体内容进行一次重新解码

     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //通知请求对象，使用utf-8字符集对请求体二进制内容进行一次重新解码
        request.setCharacterEncoding("utf-8");
        //通过请求对象，读取[请求体]中的参数信息
        String username = request.getParameter("username");
        System.out.println("从请求体得到的参数值：" + username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //通过请求对象，读取[请求头]中的参数信息
        String username = request.getParameter("username");
        System.out.println("从请求头得到的参数值：" + username);
    }
}
