package com.mos.author.dao.service.impl;

import com.mos.author.dao.dto.UserDto;
import com.mos.author.dao.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto getByUsername(String username) {
        UserDto userDto = new UserDto();
        userDto.setId(new Random().nextLong());
        userDto.setEmail("1234@163.com");
        userDto.setNickName("test");
        return userDto;
    }
}
