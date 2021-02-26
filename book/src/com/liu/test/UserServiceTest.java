package com.liu.test;

import com.liu.pojo.User;
import com.liu.service.UserService;
import com.liu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "qbs", "666", "qbs@qq.com"));
        userService.registerUser(new User(null, "lwn", "444", "lwn@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "l888n", "44", null)));

    }

    @Test
    public void existUsername() {
        if(userService.existUsername("qbs")) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用");
        }
    }
}