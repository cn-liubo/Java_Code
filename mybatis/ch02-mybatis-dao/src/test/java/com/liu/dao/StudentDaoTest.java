package com.liu.dao;

import com.liu.dao.impl.StudentDaoImpl;
import com.liu.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {
    //com.liu.dao.StudentDao
    StudentDao dao = new StudentDaoImpl();


    @Test
    public void testSelectStudents() {

        /**
         * List<Student> studentList = dao.selectStudents();调用
         * 1.dao对象，类型是StudentDao，全限定名称是：com.liu.dao.StudentDao
         *     全限定名称和namespace是一样的
         *
         * 2.方法名称，selectStudents，这个方法就是mapper文件中的id值的selectStudents
         *
         * 3.通过dao中方法的返回值也可以确定MyBatis要调用的SqlSession的方法
         *      如果返回值是List，调用的是SqlSession.selectList()方法
         *      如果返回值是int，或者非List的，看mapper文件中的标签是<insert>，<update>就会调用SqlSession的insert，update等方法
         *
         * mybatis的动态代理：mybatis根据dao的方法调用，获取执行sql语句的信息
         *      mybatis根据dao接口，创建出一个dao接口的实现类，并创建这个类的对象
         *      完成SqlSession调用方法，访问数据库
         */

        List<Student> studentList = dao.selectStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void testInsertStudent() {
        Student student = new Student(1005, "关羽", "gy@qq.com", 18);
        int number = dao.insertStudent(student);
        System.out.println("添加对象的数量：" + number);
    }
}
