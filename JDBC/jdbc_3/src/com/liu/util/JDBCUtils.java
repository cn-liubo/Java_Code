package com.liu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    /**
     * 使用C3P0的数据库连接池技术
     * @return
     * @throws SQLException
     */
    //数据库连接池只需提供一个即可
    private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
    public static Connection getConnection1() throws SQLException {
        Connection conn = cpds.getConnection();

        return conn;
    }


    /**
     * 使用DBCP的数据库连接池技术
     */
    //创建一个DBCP数据库连接池
    private static DataSource source;
    static {
        try {
            Properties properties = new Properties();

            FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));
            properties.load(is);

            source = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection2() throws Exception {

        Connection conn = source.getConnection();

        return conn;
    }


    /**
     * 使用Druid的数据库连接池技术
     */
    private static DataSource source1;
    static {
        try {
            Properties properties = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);

            source1 = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection3() throws SQLException {

        Connection conn = source1.getConnection();

        return conn;
    }

    public static void closeConnection(Connection conn, PreparedStatement ps) {
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

    public static void closeConnection(Connection conn, PreparedStatement ps, ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(conn, ps);
    }


    /**
     * 使用dbutils.jar中提供的DbUtils工具类，实现资源的关闭
     * @param conn
     * @param ps
     * @param rs
     */
    public static void closeConnection1(Connection conn, PreparedStatement ps, ResultSet rs) {
        /*try {
            DbUtils.close(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            DbUtils.close(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            DbUtils.close(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        DbUtils.closeQuietly(rs);
        DbUtils.closeQuietly(ps);
        DbUtils.closeQuietly(conn);

    }
}
