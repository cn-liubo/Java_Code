package com.liu.service;

import com.liu.model.Article;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    public List<Article> query() {
        List<Article> list = new ArrayList<>();
        Article a1 = new Article();
        a1.setId(1);
        a1.setTitle("第一篇文章");
        a1.setContent("html");
        Article a2 = new Article();
        a2.setId(2);
        a2.setTitle("第二篇文章");
        a2.setContent("js");
        list.add(a1);
        list.add(a2);
        return list;
    }
}
