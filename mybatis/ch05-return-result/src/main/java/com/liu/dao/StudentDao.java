package com.liu.dao;

import com.liu.domain.MyStudent;
import com.liu.domain.Student;
import com.liu.vo.QueryParam;
import com.liu.vo.ViewStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    public Student selectStudentById(@Param("id") Integer id);


    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    ViewStudent selectStudentReturnViewStudent(@Param("sid") Integer id);


    int countStudent();


    //定义方法返回Map
    Map<Object, Object> selectMapById(Integer id);


    //使用resultMap定义映射关系
    List<Student> selectAllStudent();


    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffCOlProperty();


    //第一种模糊查询，在java代码中指定 like的内容
    List<Student> selectLikeOne(String name);

    //第一种模糊查询，name就是李值，在mapper文件中拼接 like “%” 李 “%”
    List<Student> selectLikeTwo(String name);
}
