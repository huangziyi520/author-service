package com.canteencenter.service.impl;

import com.canteencenter.security.entity.Permission;
import com.canteencenter.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionService permissionService;

    @Override
    public Permission selectPermissionById(long id) {
        return permissionService.selectPermissionById(id);
    }

    @Override
    public long createPermission(Permission permission) {
        return permissionService.createPermission(permission);
    }

    @Override
    public long updatePermission(Permission permission) {
        return permissionService.updatePermission(permission);
    }
}
