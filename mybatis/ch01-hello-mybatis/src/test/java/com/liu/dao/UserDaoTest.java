package com.liu.dao;

import com.liu.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

    @Test
    public void testInsert() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始
        String config ="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6.指定要执行的sql语句的标识  sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "com.liu.dao.StudentDao.insertStudent";
        //7.执行sql语句，通过sqlId找到语句
        Student student = new Student(1004, "刘备", "lb@qq.com", 20);
        int number = sqlSession.insert(sqlId, student);

        //mybatis模式不是自动提交事务，所以在insert，update，delete后要手动提交事务
        sqlSession.commit();
        //8.输出结果
        System.out.println("执行insert结果：" + number);
        //9.关闭SqlSession对象
        sqlSession.close();
    }

    @Test
    public void test() throws IOException {
        //访问mybatis读取student数据
        //1.定义mybatis主配置文件的名称，从类路径的根开始
        String config ="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in = Resources.getResourceAsStream(config);
        //3.创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory = builder.build(in);
        //5.获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = factory.openSession();
        //6.指定要执行的sql语句的标识  sql映射文件中的namespace + "." + 标签的id值
//        String sqlId = "com.liu.dao.StudentDao" + "." + "selectStudents";
        String sqlId = "com.liu.dao.StudentDao.selectStudents";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentList = sqlSession.selectList(sqlId);
        //8.输出结果
//        studentList.forEach(student -> System.out.println(student));
        for (Student student : studentList) {
            System.out.println(student);
        }
        //9.关闭SqlSession对象
        sqlSession.close();
    }
}
