package com.liu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = null;
        //1.调用请求对象读取当前请求包中请求行中的URI，了解用户访问的资源文件是哪个
        String uri = request.getRequestURI();//【/网站名/资源文件名】 /myWeb/login.html  or  /myWeb/login  or  ...
        //2.如果本次请求中的资源文件与登录相关【login.html or loginServlet】，此时应该无条件放行
        // a.indexOf(b)判断当前字符串a在字符串b中第一次出现的位置
        if(uri.indexOf("login") != -1 || "/myWeb/".equals(uri)) {//说明本次请求的文件与登录资源相关 || 默认请求时也是登录页面
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //3.如果本次访问的是其他资源文件夹，需要得到用户在服务端的HttpSession
        session = request.getSession(false);
        if(session != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //4.说明该用户是恶意登录，拒绝请求
        request.getRequestDispatcher("/login_error.html").forward(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
