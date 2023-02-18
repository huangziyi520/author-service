package com.mos.author.dao.service;

import com.mos.author.dao.dto.SysPermission;

import java.util.List;

public interface PermissionService {
    List<SysPermission> findByUserId(long id);
}
