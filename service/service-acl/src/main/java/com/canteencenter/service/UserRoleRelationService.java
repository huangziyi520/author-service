package com.canteencenter.service;

import com.canteencenter.security.entity.UserRoleRelation;

import java.util.List;

/**
 * 用户权限服务类
 */
public interface UserRoleRelationService {
    UserRoleRelation selectUserRoleRelationById(long id);

    List<UserRoleRelation> selectUserRoleRelationByUserId(String userId);

    List<UserRoleRelation> selectUserRoleRelationByRoleId(String roleId);

    long createUserRoleRelation(UserRoleRelation userRoleRelation);

    long updateUserRoleRelation(UserRoleRelation userRoleRelation);
}
