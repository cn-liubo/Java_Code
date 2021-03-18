package com.liu.dao;

import com.github.pagehelper.PageHelper;
import com.liu.domain.Student;
import com.liu.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoTest {

    @Test
    public void testSelectStudentIf() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
//        student.setName("李四");
        student.setAge(18);

//        student.setName("李四");
//        student.setAge(20);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu : students) {
            System.out.println("if===" + stu);
        }
    }


    @Test
    public void testSelectStudentWhere() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("李四");
        student.setAge(18);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu : students) {
            System.out.println("where===" + stu);
        }
    }



    @Test
    public void testFor() {
        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        //String sql = "select * from student where id in(1001,1002,1003)";
        String sql = "select * from student where id in";

        StringBuilder sb = new StringBuilder("");

        //添加开始的小括号
        sb.append("(");
        for(Integer i : list) {
            sb.append(i);
            if(!list.get(list.size() - 1).equals(i)){
                sb.append(",");
            }
        }
        //添加循环的小括号
        sb.append(")");
        sql = sql + sb.toString();
        System.out.println("sql：" + sql);
    }

    @Test
    public void testSelectForEachOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);

        List<Student> students = dao.selectForEachOne(list);
        for (Student stu : students) {
            System.out.println("foreach_one===" + stu);
        }
    }

    @Test
    public void testSelectForEachTwo() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> list = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1002);
        list.add(s1);

        s1 = new Student();
        s1.setId(1005);
        list.add(s1);

        List<Student> students = dao.selectForEachTwo(list);
        for (Student stu : students) {
            System.out.println("foreach_two===" + stu);
        }
    }



    @Test
    public void testSelectAll() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //加入PageHelper的方法，分页
        //pageNum：第几页，从1开始
        //pageSize：一页中有多少行数据
        PageHelper.startPage(1, 3);

        List<Student> students = dao.selectAll();
        for (Student stu : students) {
            System.out.println("foreach_one===" + stu);
        }
    }
}
