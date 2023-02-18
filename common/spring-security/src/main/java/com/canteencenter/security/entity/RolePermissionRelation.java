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
public class RolePermissionRelation extends DataBase implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roleId;
    private String permissionId;
    private Integer isDeleted;

}
