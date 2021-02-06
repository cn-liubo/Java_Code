package com.liu.servlet;

import com.liu.exception.AppException;
import com.liu.model.JSONResponse;
import com.liu.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class AbstractBaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的编码格式
        req.setCharacterEncoding("UTF-8");
        //设置响应体的编码
        resp.setCharacterEncoding("UTF-8");
        //设置响应体的数据类型（浏览器要采取什么方式执行）
        resp.setContentType("application/json");

        //Session绘画管理：处登录和注册接口，其他都需要登录后访问
        //req.getServerPort();获取请求服务路径
        //TODO

        JSONResponse json = new JSONResponse();
        try {
            //调用子类重写的方法
            Object data = process(req, resp);
            //子类的process方法执行完没有跑异常，表示业务执行成功
            json.setSuccess(true);
            json.setData(data);
        } catch (Exception e) {
            //异常如何处理？JDBC的异常，JSON处理的异常，自定义异常返回错误消息
            e.printStackTrace();
            //json.setSuccess(false);可以不用设置，因为初new的失火就是false
            String code = "UNKNOWN";
            String s = "服务器未知的错误";
            if(e instanceof AppException) {
                code = ((AppException) e).getCode();
                s = e.getMessage();

            }
            json.setCode(code);
            json.setMessage(s);
        }
        PrintWriter pw = resp.getWriter();
        pw.write(JSONUtil.serialize(json));
        pw.flush();
        pw.close();
    }

    protected abstract Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception;

}
