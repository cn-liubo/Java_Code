package com.liu.dao;

import com.liu.domain.Student;

import java.util.List;

public interface StudentDao {

    //动态sql，使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    //where的使用
    List<Student> selectStudentWhere(Student student);

    //foreach的使用
    //用法1：
    List<Student> selectForEachOne(List<Integer> idList);
    //用法2：
    List<Student> selectForEachTwo(List<Student> idList);


    //使用PageHelper分页数据
    List<Student> selectAll();
}
