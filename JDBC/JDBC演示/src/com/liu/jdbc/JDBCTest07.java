package com.liu.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
    1.解决SQL注入问题？
        只要用户提供的信息不参与SQL语句的编译过程，问题就解决了
        即使用户提供的信息中含有SQL语句的关键字，但是没有参与编译，不起作用。
        要想用户信息不参与SQL语句的编译，那么必须使用java.sql.PreparedStatement
        PreparedStatement接口继承了java.sql.Statement
        PreparedStatement是属于预编译的数据库操作对象
        PreparedStatement的原理是，预先对SQL语句的框架进行编译，然后再给SQL语句传"值"。
    2.测试结果：
        用户名：fdsa
        密码：fdsa' or '1'='1
        登录失败
    3.解决SQL的关键是什么？
        用户提供的信息中含有sql语句的关键字，但是这些关键字并没有参与编译，不起作用。
    4，对比Statement和PreparedStatement？
        - Statement存在sql注入问题，PreparedStatement解决了sql注入问题
        - Statement是编译一次执行一次，PreparedStatement是编译一次，可执行n次，效率较高
        - PreparedStatement会在编译阶段做类型的安全检查。

        综上所述：PreparedStatement使用较多，只是极少数的情况下需要使用Statement。
    5.什么情况自下必须使用Statement？
        业务方面要求必须支持sql注入的时候
        Statement支持sql注入，凡是业务方面要求是需要进行sql语句拼接的，必须使用Statement。
 */
public class JDBCTest07 {
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
        String loginName = userLoginInfo.get("loginName");
        String loginPwd = userLoginInfo.get("loginPwd");
        //JDBC代码
        Connection connection = null;
        PreparedStatement ps = null;//这里使用PreparedStatement（预编译的数据库操作对象）
        ResultSet resultSet = null;

        try {
            //1.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");
            //3.获取预编译的数据库操作对象
            //SQL语句的框子，其中一个SQL？，表示一个占位符，一个？将来接收一个"值"，注意，占位符不能使用单引号括起来。
            String sql = "select * from t_user where loginName = ? and loginPwd = ?";
            //程序执行到此处，会发送sql语句框子给DBMS，然后DBMS进行sql语句的预先编译。
            ps = connection.prepareStatement(sql);
            //给占位符？传值（第一个问号？标是1，第2个问号下标是2，JDBC中所有下标都是从1开始）
            ps.setString(1, loginName);
            ps.setString(2, loginPwd);
            //4.执行sql
            resultSet = ps.executeQuery();
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
            if(ps != null) {
                try {
                    ps.close();
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

        System.out.print("用户名：");
        String loginName = input.nextLine();

        System.out.print("密码：");
        String loginPwd = input.nextLine();

        Map<String,String> userLoginInfo = new HashMap<>();
        userLoginInfo.put("loginName", loginName);
        userLoginInfo.put("loginPwd", loginPwd);

        return userLoginInfo;

    }
}
