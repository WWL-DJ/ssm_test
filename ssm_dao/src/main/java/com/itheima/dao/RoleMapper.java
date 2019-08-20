package com.itheima.dao;

import com.itheima.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {

    /**
     * 根据用户ID查询用户所拥有的角色信息
     * @param userId
     * @return
     */
    @Select("select * from ROLE where ID in(select ROLEID from USERINFO_ROLE where  USERID = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "ID"),
            @Result(property = "roleName",column = "ROLENAME"),
            @Result(property = "roleDesc",column = "ROLEDESC"),
            @Result(property = "permissions",column = "ID",many = @Many(select = "com.itheima.dao.PermissionsMapper.findByRoleId")),
    })
    public List<Role> findByUserId(String userId);


    /**
     * 查询所有角色信息
     * @return
     */
    @Select("select * from role")
    public List<Role> findAll();


    /**
     * 根据角色id查询角色及权限信息
     * @param id
     * @return
     */
    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "ID"),
            @Result(property = "roleName",column = "ROLENAME"),
            @Result(property = "roleDesc",column = "ROLEDESC"),
            @Result(property = "permissions",column = "ID",many = @Many(select = "com.itheima.dao.PermissionsMapper.findByRoleId")),
    })
    Role findById(String id);

    /**
     * 添加角色
     * @param role
     */
    @Insert("insert into ROLE values(sys_guid(),#{roleName},#{roleDesc})")
    void add(Role role);
}
