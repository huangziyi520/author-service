package com.mos.author.dao.service.impl;

import com.mos.author.dao.dto.SysPermission;
import com.mos.author.dao.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public List<SysPermission> findByUserId(long id) {
        List<SysPermission> permissions = new ArrayList<>();
        SysPermission sysPermission = new SysPermission();
        sysPermission.setCode(new Random().nextLong() + "");
        permissions.add(sysPermission);
        return permissions;
    }
}
