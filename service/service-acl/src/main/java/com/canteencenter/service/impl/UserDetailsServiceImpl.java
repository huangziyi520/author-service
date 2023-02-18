package com.canteencenter.service.impl;

import com.canteencenter.security.entity.*;
import com.canteencenter.service.PermissionService;
import com.canteencenter.service.RolePermissionRelationService;
import com.canteencenter.service.UserRoleRelationService;
import com.canteencenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @Autowired
    private RolePermissionRelationService rolePermissionRelationService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.selectByUsername(username);
        if (user == null) {
            throw new RuntimeException("用户不存在");
        }
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUserInfo(user);
        //根据用户信息查询出用户权限列表信息
        List<UserRoleRelation> userRoleRelations = userRoleRelationService.selectUserRoleRelationByUserId(String.valueOf(user.getId()));
        List<String> permissions = new ArrayList<>();
        if (userRoleRelations != null && userRoleRelations.size() > 0) {
            userRoleRelations.forEach(userRoleRelation -> {
                List<RolePermissionRelation> rolePermissionRelations = rolePermissionRelationService.selectRolePermissionRelationsByRoleId(userRoleRelation.getRoleId());
                if (rolePermissionRelations != null && rolePermissionRelations.size() > 0) {
                    rolePermissionRelations.forEach(rolePermissionRelation -> {
                        Permission permission = permissionService.selectPermissionById(Long.parseLong(rolePermissionRelation.getPermissionId()));
                        permissions.add(permission.getPermissionValue());
                    });
                }

            });
        }
        securityUser.setPermissionValueList(permissions);
        return securityUser;
    }
}
