package com.liu.servlet;

import com.liu.dao.ArticleDAO;
import com.liu.exception.AppException;
import com.liu.model.Article;
import com.liu.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取session，如果没有就返回null
        HttpSession session = req.getSession(false);
//        if(session == null)
//            throw new AppException("ART002", "用户没有登陆，不允许访问");
        //获取登陆时创建的session保存的用户信息
        User user = (User) session.getAttribute("user");
//        if(user == null)
//            throw new AppException("ART003", "会话异常，请重新登陆");
        //用户已登陆，并且保存了用户信息
        List<Article> articles = ArticleDAO.queryByUserId(user.getId());
        return articles;
    }
}
