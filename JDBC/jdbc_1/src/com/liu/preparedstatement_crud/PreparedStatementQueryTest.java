package com.liu.preparedstatement_crud;

import com.liu.bean.Customer;
import com.liu.bean.Order;
import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 使用PreparedStatement实现针对不同表的通用的查询操作
 */
public class PreparedStatementQueryTest {


    @Test
    public void testGetForList() {
        String sql = "select id,name,email from customers where id < ?";
        List<Customer> list = getForList(Customer.class, sql, 12);
        list.forEach(System.out::println);

        String sql1 = "select order_id orderId,order_name orderName from `order` where order_id < ?";
        List<Order> list1 = getForList(Order.class, sql1, 5);
        list1.forEach(System.out::println);

//        String sql2 = "select order_id orderId,order_name orderName from `order`";
//        List<Order> list2 = getForList(Order.class, sql1);
//        list2.forEach(System.out::println);

    }

    public <T> List<T> getForList(Class<T> clazz, String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();

            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            List<T> list = new ArrayList<T>();

            while(rs.next()) {
                T t = clazz.newInstance();

                //处理结果集一行数据中的每一列：给t对象指定的属性赋值
                for(int i  = 0; i < columnCount; i++) {
                    //获取列值
                    Object ColumnValue = rs.getObject(i + 1);

                    //获取每个列的列名
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象指定的columnName属性，赋值为columnName，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, ColumnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }



    @Test
    public void testGetInstance() {
        String sql = "select id,name,email from customers where id = ?";
        Customer customer = getInstance(Customer.class, sql, 12);
        System.out.println(customer);

        String sql1 = "select order_id orderId,order_name orderName from `order` where order_id = ?";
        Order order = getInstance(Order.class, sql1, 1);
        System.out.println(order);
    }


    /**
     * 针对于不同表的通用的查询操作，返回表中的一条记录
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T getInstance(Class<T> clazz, String sql, Object ...args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCUtils.getConnection();

            ps = conn.prepareStatement(sql);
            for(int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();

            //获取结果集的元数据：ResultSetMetaData
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetMetaData获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if(rs.next()) {
                T t = clazz.newInstance();

                //处理结果集一行数据中的每一列
                for(int i  = 0; i < columnCount; i++) {
                    //获取列值
                    Object ColumnValue = rs.getObject(i + 1);

                    //获取每个列的列名
                    //String columnName = rsmd.getColumnName(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);

                    //给t对象指定的columnName属性，赋值为columnName，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, ColumnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn, ps, rs);
        }
        return null;
    }
}
