package com.liu.test;

import com.liu.dao.DeptDao;
import com.liu.entity.Dept;

import java.util.List;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int flag = 0;
        String deptNo, dname, loc;
        DeptDao dao = new DeptDao();

        System.out.println("******欢迎使用某某公司的部门管理管理系统******");
        System.out.println("******1.添加部门******");
        System.out.println("******2.删除部门******");
        System.out.println("******3.更新部门******");
        System.out.println("******4.查询部门******");
        System.out.println("请输入操作");
        flag = input.nextInt();

        if(flag == 1) {
            System.out.println("输入新部门编号：");
            deptNo = input.next();
            System.out.println("输入新部门名称：");
            dname = input.next();
            System.out.println("输入新部门地址：");
            loc = input.next();
            flag = dao.add(deptNo, dname, loc);
            if(flag == 1) {
                System.out.println("部门添加成功");
            }else {
                System.out.println("部门添加失败");
            }

        }else if(flag == 2) {
            System.out.println("输入删除部门编号：");
            deptNo = input.next();
            flag = dao.delete(deptNo);

            if(flag == 1) {
                System.out.println("部门删除成功");
            }else {
                System.out.println("部门删除失败");
            }
        }else if(flag == 3){
            System.out.println("输入原始部门编号：");
            deptNo = input.next();
            System.out.println("输入新部门名称：");
            dname = input.next();
            System.out.println("输入新部门地址：");
            loc = input.next();
            flag = dao.update(deptNo, dname, loc);
            if(flag == 1) {
                System.out.println("部门更新成功");
            }else {
                System.out.println("部门更新失败");
            }
        }else {
            List<Dept> list =  dao.findAll();
            for(Dept dept : list) {
                System.out.println("部门编号：" + dept.getDeptNo() + "部门名称：" + dept.getDname() + "部门地址：" + dept.getLoc());
            }
        }
    }
}
