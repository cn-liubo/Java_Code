package com.liu.util;

import com.liu.exception.AppException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/bite?user=root&password=123456&useUnicode=true&characterEncoding=UTF-8&useSSL=false";

    private static final DataSource DS = new MysqlDataSource();

    /**
     * 工具类提供数据库JDBC操作
     * 不足：1.static代码块出现错误，NoClassDefFoundError表示类可以找到，但是类加载失败，无法运行
     *                ClassNotFoundException，找不到类
     *      2.学了多线程之后，可能会采取多重校验锁的单例模式来创建DataSource
     *      3.工具类的设计不是最优的，数据库框架ORM框架Mybatis，都是模板模式设计的
     */
    static {
        ((MysqlDataSource)DS).setUrl(URL);
    }
    public static Connection getConnection() {
        try {
            return DS.getConnection();
        } catch (SQLException e) {
//            e.printStackTrace();
            //抛自定义异常
            throw new AppException("DB001", "获取数据库连接失败", e);
        }
    }

    public static void close(Connection conn, Statement statement) {
        close(conn, statement, null);
    }

    public static void close(Connection conn, Statement statement, ResultSet rs) {
        try {
            if(rs != null) {
                rs.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new AppException("DB002", "数据库释放资源出错", e);
        }
    }
}
