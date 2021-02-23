package com.liu.service.impl;

import com.liu.dao.UserDao;
import com.liu.dao.impl.UserDaoImpl;
import com.liu.pojo.User;
import com.liu.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existUsername(String username) {

        if(userDao.queryUserByUsername(username) == null) {
            //等于null，说明没查到，没查到表示可用
            return false;
        }
        return true;
    }
}
