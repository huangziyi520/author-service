package com.mos.author.service.impl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //1 根据用户名去数据库查询，如果不存在则抛出异常
//        if(!"admin".equals(username)){
//            //用户名不存在
//            throw new UsernameNotFoundException("用户名不存在");
//        }
        //2 比较密码
        String encode = passwordEncoder.encode("123456");
        //ROLE_xxxx则是角色
        return new User(username,encode, AuthorityUtils.commaSeparatedStringToAuthorityList("admin,normal"));
    }
}
