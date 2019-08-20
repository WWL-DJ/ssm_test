package com.itheima.dao;

import com.itheima.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PermissionsMapper {

    /**
     * 根据角色ID查询权限信息
     * @param roleId
     * @return
     */
    @Select("select * from PERMISSION where ID in (select PERMISSIONID from ROLE_PERMISSION where  ROLEID = #{roleId})")
    public List<Permission> findByRoleId(String roleId);


    /**
     * 查询所有权限数据
     * @return
     */
    @Select("select * from PERMISSION")
    List<Permission> findAll();

    /**
     * 添加权限数据
     * @param permission
     */
    @Insert("insert into PERMISSION values(sys_guid(),#{permissionName},#{url})")
    void add(Permission permission);


    /**
     * 根据Permission id删除中间表数据
     * @param id
     */
    @Delete("delete from ROLE_PERMISSION where PERMISSIONID=#{id}")
    void delRP(String id);

    /**
     * 根据Permission id删除权限数据
     * @param id
     */
    @Delete("delete from PERMISSION where id=#{id}")
    void delP(String id);

    /**
     * 根据roleId查询权限信息
     * @param roleId
     * @return
     */
    @Select("select p.*,nvl2(t.PERMISSIONID,1,0) selected from PERMISSION p left join (select * from ROLE_PERMISSION where ROLEID = #{roleId}) t on p.ID=t.PERMISSIONID")
    List<Permission> permissionsFindByRoleId(String roleId);

    /**
     * 根据roleId删除拥有的权限
     * @param roleId
     */
    @Delete("delete from ROLE_PERMISSION where ROLEID = #{roleId}")
    void delete(String roleId);

    /**
     * 根据roleId 给角色添加权限
     * @param roleId
     * @param permissionId
     */
    @Insert("insert into ROLE_PERMISSION values(#{permissionId},#{roleId})")
    void roleAddPermission(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
