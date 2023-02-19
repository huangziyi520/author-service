package com.mos.author.service.impl;

import com.mos.author.dao.service.PermissionService;
import com.mos.author.dao.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Service
public class MyUserDetailsService implements UserDetailsService {
    private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserDto user = userService.getByUsername(username);
//        if (null == user) {
//            logger.warn("用户{}不存在", username);
//            throw new UsernameNotFoundException(username);
//        }
//        List<SysPermission> permissionList = permissionService.findByUserId(user.getId());
//        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();
//        if (!CollectionUtils.isEmpty(permissionList)) {
//            for (SysPermission sysPermission : permissionList) {
//                authorityList.add(new SimpleGrantedAuthority(sysPermission.getCode()));
//            }
//        }
//
//        MyUser myUser = new MyUser(user.getUserName(), passwordEncoder.encode(user.getPassword()), authorityList);
//
//        logger.info("登录成功！用户: {}", JSON.toJSONString(myUser));
//
//        return myUser;
//    }
}
