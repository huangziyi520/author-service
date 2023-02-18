package com.canteencenter.controller;

import com.canteencenter.security.entity.RolePermissionRelation;
import com.canteencenter.service.PermissionService;
import com.canteencenter.service.RolePermissionRelationService;
import com.canteencenter.utils.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/api")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private RolePermissionRelationService permissionRelationService;

    @GetMapping
    public Result indexAllPermission() {
        return Result.ok();
    }

    @PostMapping("/doAssignTest")
    public Result doAssign(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            RolePermissionRelation rolePermissionRelation = new RolePermissionRelation();
            rolePermissionRelation.setRoleId(roleId);
            rolePermissionRelation.setPermissionId(permissionId);
            rolePermissionRelation.setId(System.currentTimeMillis());
            rolePermissionRelation.setIsDeleted(0);
            rolePermissionRelation.setGmtModified(new Date());
            permissionRelationService.createRolePermissionRelation(rolePermissionRelation);
        }
        return Result.ok();
    }

    @PostMapping("/toAssign/{roleId}")
    public Result toAssign(@PathVariable String roleId) {
        List<RolePermissionRelation> rolePermissionRelations = permissionRelationService.selectRolePermissionRelationsByRoleId(roleId);
        return Result.ok().data("children", rolePermissionRelations);
    }
}
