package com.canteencenter.service.impl;

import com.canteencenter.security.entity.RolePermissionRelation;
import com.canteencenter.service.RolePermissionRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionRelationServiceImpl implements RolePermissionRelationService {

    @Autowired
    private RolePermissionRelationService rolePermissionRelationService;

    @Override
    public RolePermissionRelation selectRolePermissionById(long id) {
        return rolePermissionRelationService.selectRolePermissionById(id);
    }

    @Override
    public List<RolePermissionRelation> selectRolePermissionRelationsByRoleId(String roleId) {
        return rolePermissionRelationService.selectRolePermissionRelationsByRoleId(roleId);
    }

    @Override
    public List<RolePermissionRelation> selectRolePermissionRelationsByPermissionId(String permissionId) {
        return rolePermissionRelationService.selectRolePermissionRelationsByPermissionId(permissionId);
    }

    @Override
    public long createRolePermissionRelation(RolePermissionRelation rolePermissionRelation) {
        return rolePermissionRelationService.createRolePermissionRelation(rolePermissionRelation);
    }

    @Override
    public long updateRolePermissionRelation(RolePermissionRelation rolePermissionRelation) {
        return rolePermissionRelationService.updateRolePermissionRelation(rolePermissionRelation);
    }
}
