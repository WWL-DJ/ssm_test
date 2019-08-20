package com.itheima.service.impl;

import com.itheima.dao.RoleMapper;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询所有角色数据
     * @return
     */
    @Override
    public List<Role> findAll() {

        return roleMapper.findAll();
    }

    /**
     * 根据id查询角色数据
     * @param id
     * @return
     */
    @Override
    public Role findById(String id) {
        return roleMapper.findById(id);
    }

    /**
     * 新建 添加角色
     * @param role
     */
    @Override
    public void add(Role role) {
        roleMapper.add(role);
    }

    /**
     * 根据userId查询角色信息
     * @param userId
     * @return
     */
    @Override
    public List<Role> findByUserToId(String userId) {

        return roleMapper.findByUserToId(userId);
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param ids
     */
    @Override
    public void userAddRole(String userId, String[] ids) {
        // 删除用户拥有的所有角色信息
        roleMapper.deleteRolesFromUserId(userId);

        // 给用户添加角色信息
        for (String roleId : ids) {
            roleMapper.userAddRole(userId,roleId);
        }
    }


}
