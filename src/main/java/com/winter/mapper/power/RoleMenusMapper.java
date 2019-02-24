package com.winter.mapper.power;

import com.winter.model.power.RoleMenus;

public interface RoleMenusMapper {
    int deleteByPrimaryKey(String menusId);

    int insert(RoleMenus record);

    int insertSelective(RoleMenus record);

    RoleMenus selectByPrimaryKey(String menusId);

    RoleMenus selectByRoleId(String roleId);
    
    int updateByPrimaryKeySelective(RoleMenus record);

    int updateByPrimaryKey(RoleMenus record);
}