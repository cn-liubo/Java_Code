package com.liu.jdbc;

import java.sql.*;
import java.util.Scanner;

public class JDBCTest08 {
    public static void main(String[] args) {
        /*//用户在控制台输入desc就是降序，输入asc就是升序
        Scanner input = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.println("请输入：");
        String keyWords = input.nextLine();

        //执行SQL
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");
            //获取预编译的数据库操作对象
            String sql = "select ename from emp order by ename ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, keyWords);
            //执行sql
            rs = ps.executeQuery();
            //遍历结果集
            while(rs.next()) {
                System.out.println(rs.getString("ename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }*/

        //使用Statement
        //用户在控制台输入desc就是降序，输入asc就是升序
        Scanner input = new Scanner(System.in);
        System.out.println("请输入desc或asc，desc表示降序，asc表示升序");
        System.out.println("请输入：");
        String keyWords = input.nextLine();

        //执行SQL
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");
            //获取数据库操作对象
           stmt = con.createStatement();
            //执行sql
            String sql = "select ename from emp order by ename " + keyWords;
            rs = stmt.executeQuery(sql);
            //遍历结果集
            while(rs.next()) {
                System.out.println(rs.getString("ename"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
