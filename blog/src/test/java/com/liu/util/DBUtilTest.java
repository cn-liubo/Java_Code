package com.liu.util;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

public class DBUtilTest {

    @Test
    public void testConnection() {
        Connection connection = DBUtil.getConnection();
        Assert.assertNotNull(connection);//判断是否为空
    }
}
