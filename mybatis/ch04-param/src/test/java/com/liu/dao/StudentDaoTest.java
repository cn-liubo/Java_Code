package com.liu.dao;

import com.liu.domain.Student;
import com.liu.utils.MyBatisUtils;
import com.liu.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDaoTest {

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
    public void testSelectMultiObject() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam param = new QueryParam("张三", 28);
        List<Student> students = dao.selectMultiObject(param);
        for (Student student : students) {
            System.out.println("学生 = " + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("张三");
        student.setAge(28);
        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiPosition() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiPosition("李四", 20);
        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 28);

        List<Student> students = dao.selectMultiMap(map);
        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectUse$() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$("'李四';drop table student");
        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }
        sqlSession.close();
    }


    @Test
    public void testSelectUse$Order() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("age");
        for (Student stu : students) {
            System.out.println("学生 = " + stu);
        }
        sqlSession.close();
    }
}
