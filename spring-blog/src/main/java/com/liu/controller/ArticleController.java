package com.liu.controller;

import com.liu.exception.AppException;
import com.liu.model.Article;
import com.liu.model.User;
import com.liu.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/query")
    public Object query(HttpServletRequest req) {
        Map<String, Object> data = new HashMap<>();
        //需要返回用户信息（如果登录），即所有文章列表
        HttpSession session = req.getSession();
        if(session != null) {
            //session中拿到登录时保存的user对象，设置到响应数据中
            data.put("user", session.getAttribute("user"));
        }
        //设置文章列表数据，模拟数据
        List<Article> articles = articleService.query();
        data.put("articles", articles);


        return data;
    }

    @GetMapping("/query/{id}")
    public Object queryById(@PathVariable Integer id){
        //模拟有请求错误的情况
        if(id == 2)
            throw new AppException("ART001", "文章详情查询出错");
        List<Article> articles = articleService.query();
        return articles.get(0);
    }

    @PostMapping("/add")
    //请求数据已设置title，content
    public Object add(@RequestBody Article article, HttpSession session){
        User user = (User) session.getAttribute("user");
        article.setUserId(user.getId());
        article.setPublishDate(new Date());
        article.setViewCount(0);
        article.setCommentCount(0);
        //数据库插入操作：省略
        return null;
    }

    @PostMapping("/edit")
    public Object edit(@RequestBody Article article){
        //数据库修改操作：根据id修改title和content
        return null;
    }
}
