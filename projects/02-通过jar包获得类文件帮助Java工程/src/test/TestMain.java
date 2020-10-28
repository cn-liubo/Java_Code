package test;

import entity.Dept;

public class TestMain {
    public static void main(String[] args) {
        Dept dept = new Dept(10, "金融事业部", "北京");
        System.out.println("部门的编号 " + dept.getDeptNo());
        System.out.println("部门的编号 " + dept.getDname());
        System.out.println("部门的编号 " + dept.getLoc());
    }
}
