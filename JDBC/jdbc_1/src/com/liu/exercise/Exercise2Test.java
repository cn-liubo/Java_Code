package com.liu.exercise;

import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class Exercise2Test {

    /*
        问题1：向examstudent表中添加一条记录
     */
    @Test
    public void testInsert() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("四级/六级：");
        int type = 6;//scanner.nextInt();
        System.out.println("身份证号：");
        String idCard = "2342343534532";//scanner.next();
        System.out.println("准考证号：");
        String examCard = "3242342343242";//scanner.next();
        System.out.println("学生姓名：");
        String studentName = "王五";//scanner.next();
        System.out.println("所在城市：");
        String location = "日本";//scanner.next();
        System.out.println("考试成绩：");
        int grade = 80;//scanner.nextInt();

        String sql = "insert into examstudent(type,idCard,examCard,studentName,location,grade) values(?,?,?,?,?,?)";
        int insertCount = update(sql, type, idCard, examCard, studentName, location, grade);
        if(insertCount > 0) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //通用的增删改操作
    public int update(String sql, Object ...args) {//sql中占位符的个数应该与可变形参的长度相同
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.获取数据库的连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //3.填充占位符
            for(int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);//小心参数声明错误
            }
            //4.执行
            /*
                ps.execute():
                如果执行的是查询操作，有结果返回，则此方法返回true;
                如果执行的是增、删、改操作，没有返回结果，则此方法返回false.
             */
//            ps.execute();

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }
        return 0;
    }


    /*
        问题2：根据身份证号或准考账号查询学生成绩信息
     */
    @Test
    public void queryWithIDCardOrExamCard() {
        System.out.println("请选择您要输入的类型：");
        System.out.println("a:准考证号");
        System.out.println("b:身份证号:");
        Scanner scanner = new Scanner(System.in);
        String selection = "b";//scanner.next();
        if("a".equalsIgnoreCase(selection)) {
            System.out.println("请输入准考证号：");
            String examCard = "200523164754000";//scanner.nextLine();

            String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where examCard = ?";
            Student student = getInstance(Student.class, sql, examCard);
            if(student != null) {
                System.out.println(student);
            } else {
                System.out.println("输入的准考证号有误");
            }

        } else if("b".equalsIgnoreCase(selection)) {
            System.out.println("请输入身份证号：");
            String IDCard = "454524195263214584";//scanner.nextLine();

            String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where IDCard = ?";
            Student student = getInstance(Student.class, sql, IDCard);
            if(student != null) {
                System.out.println(student);
            } else {
                System.out.println("输入的身份证号有误");
            }
        } else {
            System.out.println("您的输入有误，请重新进入程序。");
        }
    }


    //针对于不同表的通用的查询操作，返回表中的一条记录
    public <T> T getInstance(Class<T> clazz, String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();

            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if(rs.next()) {
                T t = clazz.newInstance();

                //处理结果集一行数据中的每一列
                for(int i  = 0; i < columnCount; i++) {
                    //获取列值
                    Object ColumnValue = rs.getObject(i + 1);

                    //获取每个列的列名
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象指定的columnName属性，赋值为columnName，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, ColumnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }


    /*
        问题3：删除指定的学生信息
     */
    @Test
    public void testDeleteByExamCard() {
        System.out.println("请输入学生的考号");
        Scanner scanner = new Scanner(System.in);
        String examCard = "535345345";//scanner.next();
        //查询指定准考证号的学生
        String sql = "select FlowID flowID,Type type,IDCard,ExamCard examCard,StudentName name,Location location,Grade grade from examstudent where examCard = ?";
        Student student = getInstance(Student.class, sql, examCard);
        if(student == null) {
            System.out.println("查无此人，请重新输入");
        } else {
            String sql1 = "delete from examstudent where examCard = ?";
            int deleteCount = update(sql1, examCard);
            if(deleteCount > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }
    }

    //优化之后的操作：
    @Test
    public void testDeleteByExamCard1() {
        System.out.println("请输入学生的考号");
        Scanner scanner = new Scanner(System.in);
        String examCard = "200523164754001";//scanner.next();

        String sql = "delete from examstudent where examCard = ?";
        int deleteCount = update(sql, examCard);
        if(deleteCount > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("查无此人，请重新输入");
        }
    }
}
