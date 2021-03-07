package com.liu.dao;

import com.liu.domain.Student;
import com.liu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {

    @Test
    public void testSelectStudents() {
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
         * getMapper()能获取dao接口的实现类对象
         */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //dao=com.sun.proxy.$Proxy4：jdk的动态代理
        System.out.println("dao=" + dao.getClass().getName());
        //调用dao的方法，执行数据库的操作
        List<Student> studentList = dao.selectStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }

    }

    @Test
    public void testInsertStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student(1006, "凯", "k@qq.com", 20);
        int number = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("添加对象的数量：" + number);
    }
}
