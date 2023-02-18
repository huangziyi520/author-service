package com.canteencenter.service.impl;

import com.canteencenter.dao.UserDao;
import com.canteencenter.security.entity.User;
import com.canteencenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User selectByUsername(String username) {
        return userDao.selectUserByUserName(username);
    }

    @Override
    public User selectById(long id) {
        return userDao.selectUserByUserId(id);
    }

    @Override
    public long createUser(User user) {
        return userDao.createUser(user);
    }

    @Override
    public long updateUser(User user) {
        return userDao.updateUser(user);
    }
}
