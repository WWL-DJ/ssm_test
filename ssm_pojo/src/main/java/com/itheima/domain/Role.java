package com.itheima.domain;


import java.util.List;

public class Role {
    private String id;
    private String roleName;
    private String roleDesc;

    /**
     * 扩展字段 与数据库的列不对应 仅仅用于封装用户是否选择该角色
     * 1：用户关联该角色
     * 0：用户未关联该角色
     */
    private String selected;

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    /**
     * 建立角色和权限之间的实体关系  一个角色有很多个权限
     * @return
     */
    private List<Permission> permissions ;

    //建立角色与权限的实体关系
    public List<Permission> getPermissions() {
        return permissions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }



    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }


}
