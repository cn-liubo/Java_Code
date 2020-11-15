package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/*
    将连接数据库的所有信息配置到配置文件中\
    在实际开发中不建议把数据库的信息写死到java程序中
 */
public class JDBCTest04 {
    public static void main(String[] args) {

        //使用资源绑定器绑定属性配置文件
        ResourceBundle bundle = ResourceBundle.getBundle("com/liu/jdbc/jdbc");
        String driver = bundle.getString("driver");
        String url = bundle.getString("url");
        String user = bundle.getString("user");
        String password = bundle.getString("password");

        Connection connection = null;
        Statement statement = null;
        try{
            //1.注册驱动
//            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            //2.获取连接
//            String url = "jdbc:mysql://localhost:3306/bjpowernode";
//            String user = "root";
//            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
            //3.获取数据库操作对象
            statement = connection.createStatement();
            //4.执行SQL语句
            //String sql = "delete from dept where deptno = 40";
            String sql = "update dept set dname = '销售部', loc = '天津' where deptno = 50";
            //JDBC 中的sql语句不需要提供分号结尾
            int count = statement.executeUpdate(sql);
            System.out.println(count == 1 ? "修改成功" : "修改失败");
            //5.处理查询结果集

        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
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
