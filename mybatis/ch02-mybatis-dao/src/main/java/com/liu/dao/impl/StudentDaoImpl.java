package com.liu.dao.impl;

import com.liu.dao.StudentDao;
import com.liu.domain.Student;
import com.liu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.liu.dao.StudentDao.selectStudents";
        //执行sql语句，使用SqlSession类的方法
        List<Student> studentList = sqlSession.selectList(sqlId);
        //关闭
        sqlSession.close();
        return studentList;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "com.liu.dao.StudentDao.insertStudent";
        //执行sql语句，使用SqlSession类的方法
        int number = sqlSession.insert(sqlId, student);
        //提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
        return number;
    }
}
