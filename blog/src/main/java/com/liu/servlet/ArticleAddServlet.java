package com.liu.servlet;

import com.liu.dao.ArticleDAO;
import com.liu.model.Article;
import com.liu.model.User;
import com.liu.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet{

    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session = req.getSession(false);
        User user = (User)session.getAttribute("user");

        //请求数据类型是application/json，需要使用输入流获取
        InputStream is = req.getInputStream();
        //json字符串反序列化为java对象
        Article article = JSONUtil.deserialize(is, Article.class);
        article.setUserId(user.getId());
        int num = ArticleDAO.insert(article);
        return null;
    }
}
