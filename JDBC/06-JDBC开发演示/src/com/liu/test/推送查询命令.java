package com.liu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class 推送查询命令 {
    public static void main(String[] args) throws Exception {

        String sql = "select * from dept";

        //1.Driver注册
        Class.forName("com.mysql.jdbc.Driver");
        //2.建立通道
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode", "root", "123456");
        //3.建立交通工具
        PreparedStatement ps = conn.prepareStatement("");
        //4.推送命令得到处理结果
        ResultSet rs = ps.executeQuery(sql);
        //5.通过ResultSet对象将临时表所有数据行信息读取出来
        while(rs.next()) {
            int deptno = rs.getInt("deptno");
            String dname = rs.getString("dname");
            String loc = rs.getString("loc");
            System.out.println("部门编号 " + deptno + "部门名称 " + dname +"部门位置 " + loc);

        }
        //6.销毁资源
        if(rs != null) {
            rs.close();
        }
        if(ps != null) {
            ps.close();
        }
        if(conn != null) {
            conn.close();
        }

    }
}
