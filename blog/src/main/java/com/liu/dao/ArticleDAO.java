package com.liu.dao;

import com.liu.exception.AppException;
import com.liu.model.Article;
import com.liu.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public static List<Article> queryByUserId(Integer userId) {
        List<Article> articles = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select id, title from article where user_id = ?;";
            ps = conn.prepareStatement(sql);
            //设置占位符
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while(rs.next()) {
                Article article = new Article();
                //从结果集取值设置到文章对象
                article.setId(rs.getInt("id"));
                article.setTitle(rs.getString("title"));
                articles.add(article);
            }
            return articles;
        } catch (Exception e) {
            throw new AppException("ART001", "查询文章列表出错", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
    }

    public static int delete(String[] split) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            StringBuilder sql = new StringBuilder("delete from article where id in(");
            for(int i = 0; i < split.length; i++) {
                if(i != 0) {
                    sql.append(",");
                }
                sql.append("?");
            }
            sql.append(")");
            ps = conn.prepareStatement(sql.toString());
            //设置占位符
            for (int i = 0; i < split.length; i++) {
                ps.setInt(i + 1, Integer.parseInt(split[i]));
            }

            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART004", "文章删除操作出错", e);
        } finally {
            DBUtil.close(conn, ps);
        }
    }

    public static int insert(Article article) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into article(title, content,user_id) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            //替换占位符
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getUserId());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART005", "新增文章操作出错", e);
        } finally {
            DBUtil.close(conn, ps);
        }
    }

    public static Article query(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select title,content from article where id=?";
            ps = conn.prepareStatement(sql);
            //替换占位符
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Article article = null;
            while(rs.next()) {
                article = new Article();
                //根据结果集设置文章属性
                article.setId(id);
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
            }
            return article;
        } catch (Exception e) {
            throw new AppException("ART006", "查询文章详情出错", e);
        } finally {
            DBUtil.close(conn, ps, rs);
        }
    }

    public static int update(Article article) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "update article set title=?,content=? where id=?";
            ps = conn.prepareStatement(sql);
            //设置占位符
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART007", "修改文章操作出错", e);
        } finally {
            DBUtil.close(conn, ps);
        }
    }
}
