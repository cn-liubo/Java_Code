package com.liu.dao;

import com.liu.domain.MyStudent;
import com.liu.domain.Student;
import com.liu.utils.MyBatisUtils;
import com.liu.vo.QueryParam;
import com.liu.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoTest {
    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b);
    }

    @Test
    public void testSelectStudentById() {
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
         * getMapper()能获取dao接口的实现类对象
         */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1002);

        System.out.println(student);

    }

    @Test
    public void testSelectMultiParam() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiParam("李四", 20);
        for (Student student : students) {
            System.out.println("学生 = " + student);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectStudentReturnViewStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        ViewStudent student = dao.selectStudentReturnViewStudent(1005);
        System.out.println(student);
        sqlSession.close();
    }


    @Test
    public void testCountStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        int count = dao.countStudent();
        System.out.println("学生的数量：" + count);
        sqlSession.close();
    }


    @Test
    public void testSelectMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println("map=" + map);
    }


    @Test
    public void testSelectAllStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllStudent();
        for (Student student : students) {
            System.out.println("学生 = " + student);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectMyStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectMyStudent();
        for (MyStudent student : students) {
            System.out.println("学生 = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectDiffCOlProperty() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectDiffCOlProperty();
        for (MyStudent student : students) {
            System.out.println("学生 = " + student);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectLikeOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //准备好like的内容
        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);
        for (Student student : students) {
            System.out.println("学生 = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeTwo() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //准备好like的内容
        String name = "李";
        List<Student> students = dao.selectLikeTwo(name);
        for (Student student : students) {
            System.out.println("学生 = " + student);
        }
        sqlSession.close();
    }
}
