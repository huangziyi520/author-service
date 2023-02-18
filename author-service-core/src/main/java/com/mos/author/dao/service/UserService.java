package com.mos.author.dao.service;

import com.mos.author.dao.dto.UserDto;

public interface UserService {
    UserDto getByUsername(String username);
}
