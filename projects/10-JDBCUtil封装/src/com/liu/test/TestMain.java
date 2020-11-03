package com.liu.test;

import com.liu.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws Exception{

        JdbcUtil util = new JdbcUtil();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Scanner request = new Scanner(System.in);
        String username, password, deptNo, dname, loc;
        String sql_1 = "select count(*) from emp1 where ename=? and empno=?";
        String sql_2 = "insert into dept1(deptNo, dname, loc) value(?, ?, ?)";
        int flag = 0;
        //----登录验证----start
        System.out.println("请输入用户名：");
        username = request.next();
        System.out.println("请输入密码：");
        password = request.next();
        ps = util.createStatement(sql_1);
        ps.setString(1, username);
        ps.setString(2, password);
        rs = ps.    executeQuery();
        while(rs.next()) {
            flag = rs.getInt("count(*)");
        }
        util.close(rs);
        if(flag != 1) {
            System.out.println("输入信息不存在，请重新登录");
            return;
        }
        //----登录验证----end

        //----具体的功能页面----start
        System.out.println("******欢迎使用某某公司的部门管理管理系统******");
        System.out.println("******1.添加部门******");
        System.out.println("******2.查询部门******");
        System.out.println("******3.删除部门******");
        System.out.println("******4.更新部门******");
        System.out.println("请输入操作");
        flag = request.nextInt();

        if(flag == 1) {
            System.out.println("请输入部门编号：");
            deptNo = request.next();
            System.out.println("请输入部门名称：");
            dname = request.next();
            System.out.println("请输入部门位置：");
            loc = request.next();

            ps = util.createStatement(sql_2);
            ps.setInt(1, Integer.parseInt(deptNo));
            ps.setString(2, dname);
            ps.setString(3, loc);
            flag = ps.executeUpdate();
            util.close();

        }else if(flag == 2) {

        }else if(flag == 3) {

        }else {

        }

        //----具体的功能页面----end

    }
}
