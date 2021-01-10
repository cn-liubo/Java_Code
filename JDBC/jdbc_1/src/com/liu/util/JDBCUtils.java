package com.liu.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 数据库的工具类
 */

public class JDBCUtils {

    /**
     * 获取数据库的连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception{
        //1.读取配置文件中的的4个基本信息
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
        Connection conn = DriverManager.getConnection(url, user, password);

        return conn;
    }

    /**
     * 关闭连接和Statement的操作
     * @param conn
     * @param ps
     */
    public static void closeResource(Connection conn, Statement ps) {
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

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
