package com.canteencenter.controller;

import com.canteencenter.security.entity.UserRoleRelation;
import com.canteencenter.service.UserRoleRelationService;
import com.canteencenter.utils.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRoleRelationService userRoleRelationService;

    @PostMapping("/doAssign")
    public Result doAssign(@RequestParam String userId, @RequestParam String[] roleIds) {
        for (String roleId : roleIds) {
            UserRoleRelation userRoleRelation = new UserRoleRelation();
            userRoleRelation.setUserId(userId);
            userRoleRelation.setId(System.currentTimeMillis());
            userRoleRelation.setRoleId(roleId);
            userRoleRelation.setIsDeleted(0);
            userRoleRelation.setGmtModified(new Date());
            userRoleRelationService.createUserRoleRelation(userRoleRelation);
        }
        return Result.ok();
    }
}
