package com.liu.chat.server.service;

/**
 * 用户管理接口
 */
public interface UserService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回true，否则返回false
     */
    boolean login(String username, String password);
}
