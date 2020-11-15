package com.liu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    注册驱动的另一种方式（这种方式常用）
 */
public class JDBCTest03 {
    public static void main(String[] args) {

        try{
            //1.注册驱动
            //这是注册驱动的第一种写法
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            //注册驱动的第二种写法，常用的
            //为什么这种方式常用？因为参数是一个字符串，字符串可以写到xxx.properties文件中
            //以下方法不需要接受返回值，因为我们只想用它的类加载的动作
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode","root", "123456");
            System.out.println(connection);
            //3.获取数据库操作对象
            //4.执行SQL语句
            //5.处理查询结果集
            //6.释放资源
        }catch(SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
