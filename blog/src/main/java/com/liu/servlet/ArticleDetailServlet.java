package com.liu.servlet;

import com.liu.dao.ArticleDAO;
import com.liu.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDetail")
public class ArticleDetailServlet extends AbstractBaseServlet {

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String id = req.getParameter("id");
        Article article = ArticleDAO.query(Integer.parseInt(id));
        return article;
    }
}
