package com.liu.transaction;

import com.liu.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;

public class ConnectionTest {

    @Test
    public void testGetConnection() throws Exception {
        Connection conn = JDBCUtils.getConnection();
        System.out.println(conn);
    }
}
