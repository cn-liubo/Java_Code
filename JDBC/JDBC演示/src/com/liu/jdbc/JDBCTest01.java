package com.liu.jdbc;

/*
	JDBC编程六步
*/

import java.sql.*;

public class JDBCTest01 {
    public static void main(String[] args){

        Connection connection = null;
        Statement statement = null;
        try {
            //1.注册驱动
            Driver driver = new com.mysql.jdbc.Driver();//多态，父类型的引用指向子类型的对象
            //Driver driver = new oracle.jdbc.driver.OracleDriver();//oracle驱动
            DriverManager.registerDriver(driver);

            //2.获取连接
            /*
                url：统一资源定位符（网络中某个资源的绝对路径）
                https://www.baidu.com/ 这就是URL
                URL包括哪几部分？
                    协议
                    IP
                    PORT
                    资源名
                http://36.152.44.95/index.html
                    http:// 通信协议
                    36.152.44.95 服务器IP地址
                    80 服务器上软件的端口
                    index.html 服务器上某个资源名

                jdbc:mysql://127.0.0.1:3306/bjpowernode
                    jdbc:mysql:// 协议
                    127.0.0.1 IP地址
                    3306 mysql数据库端口号
                    bjpowernode 具体的数据库实例名

                说明：localhost 和 127.0.0.1 都是本机IP

                jdbc:mysql://127.0.0.1:3306/bjpowernode

                什么是通信协议，有什么用？
                    通信协议是通信之前就提前定好的数据传送格式。
                    数据包具体怎么传数据，格式提前定好的。

                oracle的URL：
                    jdbc:oracle:thin:@127.0.0.1:1521:orcl
             */
            String url = "jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user = "root";
            String password = "123456";
            connection = DriverManager.getConnection(url, user, password);
            //com.mysql.jdbc.JDBC4Connection@1a86f2f1

            //3,获取数据库操作对象（Statement专门执行sql语句）
            statement = connection.createStatement();

            //4.执行sql
            String sql = "insert into dept(deptno, dname, loc) value(50, '人事部', '北京' )";
            //专门执行DML语句的（insert delete update）
            //返回值是“影响数据库中记录的条数”
            int count = statement.executeUpdate(sql);
            System.out.println(count == 1 ?  "保存成功" : "保存失败");

            //5.处理查询结果集


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            //为了保证资源一定释放，在finally语句块中关闭资源
            //并且遵循从小到大依次关闭
            //分别对其try...catch
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
                ;
            }
        }

    }
}
