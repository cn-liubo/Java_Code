package com.liu.preparedstatement_crud;

import com.liu.connection.ConnectionTest;
import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

/*
    使用PreparedStatement来替换Statement，实现对数据库的增删改查操作

    增删改；查
 */
public class PreparedStatementUpdateTest {

    @Test
    public void testCommonUpdate() {

//        String sql = "delete from customers where id = ?";
//        update(sql, 3);

        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql, "DD", "2");
    }

    //通用的增删改操作
    public void update(String sql, Object ...args) {//sql中占位符的个数应该与可变形参的长度相同
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);//小心参数声明错误
            }
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }


    //修改customers表的一条记录
    @Test
    public void testUpdate() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            ps.setObject(1,"莫扎特");
            ps.setObject(2,18);
            //4.执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
    }

    //向customers表中添加一条数据
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.读取配置文件中的的4个基本信息
            //InputStream input = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(input);

            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");

            //2.加载驱动
            Class.forName(driverClass);

            //3.获取连接
            conn = DriverManager.getConnection(url, user, password);

            //4.预编译sql语句，返回PreparedStatement实例
            String sql = "insert into customers(name,email,birth) value(?,?,?)";//?:占位符
            ps = conn.prepareStatement(sql);

            //5.填充占位符
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@qq.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new Date(date.getTime()));

            //6.执行操作
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            //7.资源的关闭
            try {
                if(ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
