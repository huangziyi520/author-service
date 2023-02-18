package com.canteencenter.controller;

import com.alibaba.fastjson.JSONObject;
import com.canteencenter.security.entity.User;
import com.canteencenter.security.entity.UserRoleRelation;
import com.canteencenter.service.PermissionService;
import com.canteencenter.service.UserService;
import com.canteencenter.service.impl.UserRoleRelationServiceImpl;
import com.canteencenter.utils.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api")
public class IndexController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleRelationServiceImpl userRoleRelationService;

    @Autowired
    private PermissionService permissionService;


    @GetMapping("/info")
    public Result info() {

        //获取当前登陆用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.selectByUsername(username);
        return Result.ok().data("userInfo", JSONObject.toJSONString(user));
    }

    @GetMapping("/menu")
    public Result getMenu() {

        //获取当前登陆用户名
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.selectByUsername(username);
        List<UserRoleRelation> userRoleRelations = userRoleRelationService.selectUserRoleRelationByUserId(String.valueOf(user.getId()));
        return Result.ok().data("userInfo", JSONObject.toJSONString(user));
    }
}