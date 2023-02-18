package com.canteencenter.service;

import com.canteencenter.security.entity.RolePermissionRelation;

import java.util.List;

/**
 * 用户权限服务类
 */
public interface RolePermissionRelationService {
    RolePermissionRelation selectRolePermissionById(long id);

    List<RolePermissionRelation> selectRolePermissionRelationsByRoleId(String roleId);

    List<RolePermissionRelation> selectRolePermissionRelationsByPermissionId(String permissionId);

    long createRolePermissionRelation(RolePermissionRelation rolePermissionRelation);

    long updateRolePermissionRelation(RolePermissionRelation rolePermissionRelation);
}
