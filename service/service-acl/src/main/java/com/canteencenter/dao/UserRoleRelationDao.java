package com.canteencenter.dao;

import com.canteencenter.security.entity.UserRoleRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleRelationDao {
    UserRoleRelation selectUserRoleRelationById(@Param("id") long id);

    List<UserRoleRelation> selectUserRoleRelationByUserId(@Param("userId") String userId);

    List<UserRoleRelation> selectUserRoleRelationByRoleId(@Param("roleId") String roleId);

    long createUserRoleRelation(UserRoleRelation userRoleRelation);

    long updateUserRoleRelation(UserRoleRelation userRoleRelation);
}
