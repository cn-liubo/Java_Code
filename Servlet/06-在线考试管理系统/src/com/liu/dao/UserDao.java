package com.liu.dao;

import com.liu.entity.Users;
import com.liu.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private JdbcUtil util = new JdbcUtil();
    //用户注册
    public int add(Users user) {
        String sql = "insert into users(username,password,sex,email) value(?,?,?,?)";
        int result = 0;

        PreparedStatement ps = util.createStatement(sql);
        try {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getSex());
            ps.setString(4, user.getEmail());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    //查询所有用户信息
    public List find() {
        String sql = "select * from users";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        List list = new ArrayList();
        try {
            rs = ps.executeQuery();
            while(rs.next()) {
                Integer userId = rs.getInt("userId");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                String email = rs.getString("email");
                Users user = new Users(userId, username, password, sex, email);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return list;
    }

    //根据用户编号删除用户信息
    public int delete(String userId) {
        String sql = "delete from users where userId=?";
        PreparedStatement ps = util.createStatement(sql);
        int result = 0;
        try {
            ps.setString(1, userId);
            //ps.setInt(1, Integer.parseInt(userId));
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close();
        }
        return result;
    }

    //登录验证
    public int login(String username, String password) {
        String sql = "select count(*) from users where username=? and password=?";
        PreparedStatement ps = util.createStatement(sql);
        ResultSet rs = null;
        int result = 0;
        try {
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()) {
                result = rs.getInt("count(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs);
        }
        return result;
    }
}
