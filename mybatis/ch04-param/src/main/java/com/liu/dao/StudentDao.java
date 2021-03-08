package com.liu.dao;

import com.liu.domain.Student;
import com.liu.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    /*
        一个简单类型的参数：
            简单类型：mybatis把java的基本数据类型和String都叫简单类型

        在mapper文件中获取简单类型的一个参数的值，使用#{任意字符}

     */
    public Student selectStudentById(@Param("id") Integer id);

    /*
        多个参数，命名参数，在形参定义的前面加入 @Param("自定义参数名称")
     */
    List<Student> selectMultiParam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    /*
        多个餐宿，使用java对象作为接口中方法的参数
     */
    List<Student> selectMultiObject(QueryParam param);

    List<Student> selectMultiStudent(Student student);


    //以下的传参方法不建议使用
    /*
        多个参数-简单类型，按位置传值
        mybatis 3.4之前，使用 #{0}， #{1}
        mybatis 3.4之后，使用 #{arg0}, #{arg1}
     */
    List<Student> selectMultiPosition(String name,Integer age);

    /*
        多个参数，使用Map存放多个值
     */
    List<Student> selectMultiMap(Map<String, Object> map);


    List<Student> selectUse$(@Param("name") String name);


    /*
        $ 和 # 的区别
        1.# 使用 ? 在语句中做占位符，使用PreparedStatement执行sql语句，效率高
        2.使用 # 能避免sql注入，更安全
        3.$ 不适用占位符，是字符串连接的方式，使用Statement执行sql语句，效率低
        4.$ 有sql注入的风险，缺乏安全性
        5.$ 可以替换表名或者列名
     */
    List<Student> selectUse$Order(@Param("colName") String colName);
}
