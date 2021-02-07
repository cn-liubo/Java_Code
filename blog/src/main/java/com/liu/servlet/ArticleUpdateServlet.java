package com.liu.servlet;

import com.liu.dao.ArticleDAO;
import com.liu.model.Article;
import com.liu.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is, Article.class);
        int num = ArticleDAO.update(article);
        return null;
    }
}
