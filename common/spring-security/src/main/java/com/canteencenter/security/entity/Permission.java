package com.canteencenter.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends DataBase implements Serializable {
    private static final long serialVersionUID = 1L;
    //所属上级
    private String pid;
    //名称
    private String name;
    //类型(1:菜单,2:按钮)
    private Integer type;
    //权限值
    private String permissionValue;
    //访问路径
    private String path;
    //组件路径
    private String component;
    //图标
    private String icon;
    //状态(0:禁止,1:正常)
    private Integer status;
    //逻辑删除 1（true）已删除， 0（false）未删除
    private Integer isDeleted;
}
