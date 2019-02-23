package com.winter.model.power;

public class RoleUser {
    private Integer id;

    private String roleName;

    private String roleDepict;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDepict() {
        return roleDepict;
    }

    public void setRoleDepict(String roleDepict) {
        this.roleDepict = roleDepict == null ? null : roleDepict.trim();
    }
}