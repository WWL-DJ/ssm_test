package com.itheima.service.impl;

import com.itheima.dao.PermissionsMapper;
import com.itheima.domain.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionsMapper permissionsMapper;

    @Override
    public List<Permission> findAll() {
        return permissionsMapper.findAll();
    }

    /**
     * 添加权限数据
     * @param permission
     */
    @Override
    public void add(Permission permission) {
        permissionsMapper.add(permission);
    }

    /**
     * 删除权限数据
     * @param id
     */
    @Override
    public void del(String id) {
        permissionsMapper.delRP(id);
        permissionsMapper.delP(id);

    }

    /**
     * 查询角色的权限
     * @param roleId
     * @return
     */
    @Override
    public List<Permission> permissionsFindByRoleId(String roleId) {
        List<Permission> permissions = permissionsMapper.permissionsFindByRoleId(roleId);
        return permissions;
    }

    /**
     * 根据roleId添加权限
     * @param roleId
     * @param ids
     */
    @Override
    public void roleAddPermission(String roleId, String[] ids) {
        //先删除用户所拥有的所有权限
        permissionsMapper.delete(roleId);

        for (String permissionId : ids) {
            permissionsMapper.roleAddPermission(roleId,permissionId);
        }
    }


}
