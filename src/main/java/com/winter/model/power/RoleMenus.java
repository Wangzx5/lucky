package com.winter.model.power;

public class RoleMenus {
    private Integer menusId;

    private String roleId;

    private String menusUrl;

    private String menusDepict;

    public Integer getMenusId() {
        return menusId;
    }

    public void setMenusId(Integer menusId) {
        this.menusId = menusId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getMenusUrl() {
        return menusUrl;
    }

    public void setMenusUrl(String menusUrl) {
        this.menusUrl = menusUrl == null ? null : menusUrl.trim();
    }

    public String getMenusDepict() {
        return menusDepict;
    }

    public void setMenusDepict(String menusDepict) {
        this.menusDepict = menusDepict == null ? null : menusDepict.trim();
    }
}