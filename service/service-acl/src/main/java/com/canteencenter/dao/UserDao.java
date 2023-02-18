package com.canteencenter.dao;

import com.canteencenter.security.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User selectUserByUserId(@Param("id") long id);

    User selectUserByUserName(@Param("username") String username);

    long createUser(User user);

    long updateUser(User user);
}
