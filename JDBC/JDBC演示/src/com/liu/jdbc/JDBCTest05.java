package com.liu.jdbc;

import java.sql.*;

public class JDBCTest05 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {

            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");

            //3.获取数据库操作对象
            statement = connection.createStatement();

            //4.执行sql
            String sql = "select empno as a,ename,sal from emp";
            //int executeUpdate(insert/delete/update)
            //ResultSet executeQuery(select)
            resultSet = statement.executeQuery(sql);//专门执行DQL语句的方法

            //5.处理查询结果集
            /*boolean b = resultSet.next();
            //System.out.println(b);//true
            if(b) { //光标指向的行有数据
                //取数据
                //getString()方法的特点是：不管数据库中的数据类型是什么，都以String的形式取出
                //以下程序的1 2 3说的是第几列
                String empno = resultSet.getString(1);//JDBC中所有的下标都是从1开始，不是从0开始
                String ename = resultSet.getString(2);
                String sal = resultSet.getString(3);
                System.out.println(empno + "," + ename + "," +  sal);
            }*/
            while(resultSet.next()) {
                /*
                String empno = resultSet.getString(1);//JDBC中所有的下标都是从1开始，不是从0开始
                String ename = resultSet.getString(2);
                String sal = resultSet.getString(3);
                System.out.println(empno + "," + ename + "," +  sal);
                */

                /*
                //这个不是以列的下标获取，而是以列的名字获取
                //String empno = resultSet.getString("empno");//JDBC中所有的下标都是从1开始，不是从0开始
                String empno = resultSet.getString("a");//重点注意：列名称不是表的列名称，而是查询结果集的列名称
                String ename = resultSet.getString("ename");
                String sal = resultSet.getString("sal");
                System.out.println(empno + "," + ename + "," +  sal);
                */

                //除了可以以String类型取出之外，还可以以特定的类型取出
                /*
                int empno = resultSet.getInt(1);//JDBC中所有的下标都是从1开始，不是从0开始
                String ename = resultSet.getString(2);
                double sal = resultSet.getDouble(3);
                System.out.println(empno + "," + ename + "," +  (sal + 100));
                */
                int empno = resultSet.getInt("a");//JDBC中所有的下标都是从1开始，不是从0开始
                String ename = resultSet.getString("ename");
                double sal = resultSet.getDouble("sal");
                System.out.println(empno + "," + ename + "," +  (sal + 200));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //6.释放资源
            if(resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
