package com.liu.blob;

import com.liu.bean.Customer;
import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

/**
 * 测试使用PreparedStatement操作Blob类型的数据
 */
public class BlobTest {

    //向数据表customers中插入Blob类型的字段
    @Test
    public void testInsert() {
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream fis = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into customers(name,email,birth,photo) values(?,?,?,?)";

            ps = conn.prepareStatement(sql);
            ps.setObject(1, "赵丽颖");
            ps.setObject(2, "zhao@qq.com");
            ps.setObject(3, "1987-10-16");
            fis = new FileInputStream(new File("zly.jpg"));
            ps.setBlob(4, fis);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn, ps);
        }
    }


    //查询数据表customers中的Blob类型的字段
    @Test
    public void testQuery() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "select id,name,email,birth,photo from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, 21);

            rs = ps.executeQuery();
            if(rs.next()) {
                //方式一：索引
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                String email = rs.getString(3);
//                Date birth = rs.getDate(4);
                //方式二：列的别名
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");

                Customer customer = new Customer(id, name, email, birth);
                System.out.println(customer);

                //将Blob类型的字段下载下来，以文件的方式保存在本地
                Blob photo = rs.getBlob("photo");
                is = photo.getBinaryStream();
                fos = new FileOutputStream("zhaoliying.jpg");
                byte[] buffer = new byte[1024];
                int len;
                while((len = is.read(buffer)) != -1) {
                    fos.write(buffer, 0, len);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(conn, ps, rs);
        }


    }
}
