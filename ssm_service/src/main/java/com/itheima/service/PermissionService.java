package com.itheima.service;

import com.itheima.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void add(Permission permission);


    void del(String id);


    List<Permission> permissionsFindByRoleId(String roleId);

    void roleAddPermission(String roleId, String[] ids);
}
