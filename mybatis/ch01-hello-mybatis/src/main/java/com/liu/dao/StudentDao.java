package com.liu.dao;

import com.liu.domain.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询Student表中所有的数据
     * @return
     */
    public List<Student> selectStudents();

    /**
     * 插入数据
     * @param student 表示要插入到数据库的数据
     * @return 表示执行insert操作后，影响数据库的行数
     */
    public int insertStudent(Student student);
}
