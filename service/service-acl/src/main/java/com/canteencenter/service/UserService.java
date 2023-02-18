package com.canteencenter.service;

import com.canteencenter.security.entity.User;

/**
 * 用户表服务类
 */
public interface UserService{

    //从数据库中取出用户信息
    User selectByUsername(String username);
    User selectById(long id);
    long createUser(User user);
    long updateUser(User user);
}
