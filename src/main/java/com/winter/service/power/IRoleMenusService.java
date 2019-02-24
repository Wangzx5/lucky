package com.winter.service.power;

import com.winter.model.power.RoleMenus;

public interface IRoleMenusService {

    RoleMenus selectByRoleId(String roleId);
    
}
