package com.liu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/backend/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        Cookie[] cookies = request.getCookies();
        if(cookies == null) {
            request.getRequestDispatcher("/backend/login.jsp").forward(req, resp);
        } else {
            for(Cookie cookie : cookies) {
                if(cookie.getName().equals("username")) {
                    chain.doFilter(req, resp);
                    //request.getRequestDispatcher("/backend/shopping.jsp").forward(req, resp);
                    return;
                }
            }
        }
        HttpSession session = request.getSession(false);
        if(session != null) {
            chain.doFilter(req, resp);
            return;
        }
        //4.说明该用户是恶意登录，拒绝请求
        request.getRequestDispatcher("/backend/login.jsp").forward(req, resp);


        /*HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = null;
        //1.调用请求对象读取当前请求包中请求行中的URI，了解用户访问的资源文件是哪个
        String uri = request.getRequestURI();//【/网站名/资源文件名】 /myWeb/login.html  or  /myWeb/login  or  ...
        //2.如果本次请求中的资源文件与登录相关【login.html or loginServlet】，此时应该无条件放行

        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        // 如果为空，则停留在该页面
        if(cookies == null){
            return ;
            // 不为空则获取用户名和密码
        }else {
            for (int i = 0; i < cookies.length; i++) {
                Cookie temp = cookies[i];
                if (temp.getName().equals("username")) {
                    request.getRequestDispatcher("/backend/shopping.jsp").forward(request, response);
                }
            }
        }

        if(uri.indexOf("login") != -1 || "/myWeb/".equals(uri)) {//说明本次请求的文件与登录资源相关 || 默认请求时也是登录页面
            chain.doFilter(req, resp);
            return;
        }
        //3.如果本次访问的是其他资源文件夹，需要得到用户在服务端的HttpSession
        session = request.getSession(false);
        if(session != null) {
            chain.doFilter(req, resp);
            return;
        }
        //4.说明该用户是恶意登录，拒绝请求
        request.getRequestDispatcher("/backend/login.jsp").forward(req, resp);*/
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
