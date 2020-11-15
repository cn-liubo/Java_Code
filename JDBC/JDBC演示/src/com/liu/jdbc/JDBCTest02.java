package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
    JDBC完成delete
 */
public class JDBCTest02 {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        try{
            //1.注册驱动
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root", "123456");
            //3.获取数据库操作对象
            statement = connection.createStatement();
            //4.执行SQL语句
            String sql = "delete from dept where deptno = 40";
            //String sql = "update dept set dname = '销售部', loc = '天津' where deptno = 20";
            //JDBC 中的sql语句不需要提供分号结尾
            int count = statement.executeUpdate(sql);
            System.out.println(count == 1 ? "删除成功" : "删除失败");
            //5.处理查询结果集

        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            //6.释放资源
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
