package com.canteencenter.service.impl;

import com.canteencenter.security.entity.UserRoleRelation;
import com.canteencenter.service.UserRoleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleRelationServiceImpl implements UserRoleRelationService {

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @Override
    public UserRoleRelation selectUserRoleRelationById(long id) {
        return userRoleRelationService.selectUserRoleRelationById(id);
    }

    @Override
    public List<UserRoleRelation> selectUserRoleRelationByUserId(String userId) {
        return userRoleRelationService.selectUserRoleRelationByUserId(userId);
    }

    @Override
    public List<UserRoleRelation> selectUserRoleRelationByRoleId(String roleId) {
        return userRoleRelationService.selectUserRoleRelationByRoleId(roleId);
    }

    @Override
    public long createUserRoleRelation(UserRoleRelation userRoleRelation) {
        return userRoleRelationService.createUserRoleRelation(userRoleRelation);
    }

    @Override
    public long updateUserRoleRelation(UserRoleRelation userRoleRelation) {
        return userRoleRelationService.updateUserRoleRelation(userRoleRelation);
    }
}
