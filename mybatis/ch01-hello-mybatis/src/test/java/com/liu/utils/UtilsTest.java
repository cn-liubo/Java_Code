package com.liu.utils;

import com.liu.domain.Student;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UtilsTest {

    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.liu.dao.StudentDao.selectStudents";
        List<Student> studentList = sqlSession.selectList(sqlId);
        for (Student student : studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }
}
