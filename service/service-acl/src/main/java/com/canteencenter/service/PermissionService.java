package com.canteencenter.service;

import com.canteencenter.security.entity.Permission;

/**
 * 用户权限服务类
 */
public interface PermissionService{
    Permission selectPermissionById(long id);

    long createPermission(Permission permission);

    long updatePermission(Permission permission);
}
