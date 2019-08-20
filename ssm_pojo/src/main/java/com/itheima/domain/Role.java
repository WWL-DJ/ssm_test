package com.itheima.domain;


import java.util.List;

public class Role {
    private String id;
    private String roleName;
    private String roleDesc;

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
