package com.liu.dao;

import com.liu.bean.Customer;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 此接口用于规范针对于customers表的常用操作
 */
public interface CustomerDAO {

    /**
     * 将customer对象添加到数据库中
     * @param conn
     * @param customer
     */
    void insert(Connection conn, Customer customer);

    /**
     * 根据指定的id，删除表中的一条记录
     * @param conn
     * @param id
     */
    void deleteById(Connection conn, int id);

    /**
     * 根据内存中的customer对象，去修改数据库表中的指定的记录
     * @param conn
     * @param customer
     */
    void update(Connection conn, Customer customer);

    /**
     * 根据指定的id查询得到对应的Customer对象
     * @param conn
     * @param id
     */
    Customer getCustomerById(Connection conn, int id);

    /**
     * 查询表中的所有记录构成的集合
     * @param conn
     * @return
     */
    List<Customer> getAll(Connection conn);

    /**
     * 返回数据表中数据的条目数
     * @param conn
     * @return
     */
    Long getCount(Connection conn);

    /**
     * 返回数据库表中最大的生日
     * @param conn
     * @return
     */
    Date getMaxBirth(Connection conn);
}
