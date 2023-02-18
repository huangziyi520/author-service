package com.mos.author.service;

import com.mos.author.service.entity.UserDetails;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String username);

}
