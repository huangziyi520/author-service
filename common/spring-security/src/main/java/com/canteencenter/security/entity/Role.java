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
public class Role extends DataBase implements Serializable {
    private static final long serialVersionUID = 1L;
    //角色名称
    private String roleName;
    //角色编码
    private String roleCode;
    //备注
    private String remark;
    //逻辑删除 1（true）已删除， 0（false）未删除
    private String isDeleted;
}
