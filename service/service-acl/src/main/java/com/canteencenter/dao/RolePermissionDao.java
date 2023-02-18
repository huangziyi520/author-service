package com.canteencenter.dao;

import com.canteencenter.security.entity.RolePermissionRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolePermissionDao {
    RolePermissionRelation selectRolePermissionById(@Param("id") long id);

    List<RolePermissionRelation> selectRolePermissionRelationsByRoleId(@Param("roleId") String roleId);

    List<RolePermissionRelation> selectRolePermissionRelationsByPermissionId(@Param("permissionId") String permissionId);

    long createRolePermissionRelation(RolePermissionRelation rolePermissionRelation);

    long updateRolePermissionRelation(RolePermissionRelation rolePermissionRelation);
}
