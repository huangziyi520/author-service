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
public class UserRoleRelation extends DataBase implements Serializable {
    private static final long serialVersionUID = 1L;
    //角色id
    private String roleId;
    //用户id
    private String userId;
    //逻辑删除 1（true）已删除， 0（false）未删除
    private Integer isDeleted;
}
