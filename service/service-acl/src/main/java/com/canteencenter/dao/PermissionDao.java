package com.canteencenter.dao;

import com.canteencenter.security.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionDao {
    Permission selectPermissionById(@Param("id") long id);

    long createPermission(Permission permission);

    long updatePermission(Permission permission);
}
