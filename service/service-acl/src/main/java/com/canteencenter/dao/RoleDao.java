package com.canteencenter.dao;

import com.canteencenter.security.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
    Role selectRoleById(@Param("id") long id);

    Role selectRoleByRoleCode(@Param("roleCode") String roleCode);

    long createRole(Role role);

    long updateRole(Role role);
}
