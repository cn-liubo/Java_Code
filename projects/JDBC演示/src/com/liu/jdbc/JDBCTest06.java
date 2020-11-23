package com.liu.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    1.需求：
        模拟用户登录功能的实现
    2.业务描述：
        程序运行的时候，提供一个输入的入口，可以让用户输入用户名和密码
        用户输入用户名和密码之后，提交信息，java程序收集到用户的信息
        java程序连接数据库验证用户名和密码是否合法
        合法：显示登陆成功
        不合法：显示登陆失败
    3.数据的准备：
        在实际开发中，表的设计会使用专业的建模工具，PowerDesigner
        使用PD工具来进行数据库表的设计(参见user-login.sql脚本)
    4.当前程序存在的问题：
        用户名：fdsa
        密码：fdsa' or '1'='1
        登录成功
        这种现象被称为SQL注入。安全隐患（黑客经常使用）
    5.导致SQL注入的根本原因是什么？
        用户输入的信息中含有sql语句的关键字，并且这些关键字参与sql语句的编译过程，
        导致sql语句的原意被扭曲，进而达到sql注入。
 */
public class JDBCTest06 {
    public static void main(String[] args) {
        //初始化一个界面
        Map<String, String> userLoginInfo = initUI();
        //验证用户名和密码
        boolean loginResult = login(userLoginInfo);
        //输出结果
        System.out.println(loginResult ? "登录成功" : "登录失败");
    }

    /**
     * 用户登录
     * @param userLoginInfo 用户登录信息
     * @return false表示失败，true表示成功
     */
    private static boolean login(Map<String, String> userLoginInfo) {

        boolean loginFlag = false;
        //JDBC代码
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
            String sql = "select * from t_user where loginName = '" + userLoginInfo.get("loginName") + "' and loginPwd = '"+userLoginInfo.get("loginPwd")+"'";
            //以上正好完成了sql语句的拼接，以下代码的含义是，发送sql语句给DBMS，DBMS进行sql编译。
            //正好将用户提供的非法信息编译进去，导致了原sql语句的含义被扭曲。
            resultSet = statement.executeQuery(sql);
            //5.处理结果集
            if(resultSet.next()){
                //登录成功
                loginFlag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
        return loginFlag;
    }

    /**
     * 初始化用户界面
     * @return 用户输入的用户名和密码等登陆信息
     */
    private static Map<String, String> initUI() {
        Scanner input = new Scanner(System.in);

        System.out.println("用户名：");
        String loginName = input.nextLine();

        System.out.println("密码：");
        String loginPwd = input.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName", loginName);
        userLoginInfo.put("loginPwd", loginPwd);

        return userLoginInfo;

    }
}
