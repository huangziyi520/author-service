package com.canteencenter.service.impl;

import com.canteencenter.security.entity.Role;
import com.canteencenter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleService roleService;

    @Override
    public Role selectRoleByRoleId(long id) {
        return roleService.selectRoleByRoleId(id);
    }

    @Override
    public Role selectRoleByRoleCode(String roleCode) {
        return roleService.selectRoleByRoleCode(roleCode);
    }

    @Override
    public long createRole(Role role) {
        return roleService.createRole(role);
    }

    @Override
    public long updateRole(Role role) {
        return roleService.updateRole(role);
    }
}
