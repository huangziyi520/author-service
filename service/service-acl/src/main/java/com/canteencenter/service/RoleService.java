package com.canteencenter.service;

import com.canteencenter.security.entity.Role;

/**
 * 用户权限服务类
 */
public interface RoleService {
    Role selectRoleByRoleId(long id);

    Role selectRoleByRoleCode(String roleCode);

    long createRole(Role role);

    long updateRole(Role role);
}
