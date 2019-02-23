package com.winter.service.power.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.mapper.power.RoleMenusMapper;
import com.winter.model.power.RoleMenus;
import com.winter.service.power.IRoleMenusService;

@Service
public class RoleMenusServiceImpl implements IRoleMenusService{

	@Autowired
	RoleMenusMapper roleMenusMapper;
	
	@Override
	public RoleMenus selectByRoleId(String roleId) {
		// TODO Auto-generated method stub
		return roleMenusMapper.selectByRoleId(roleId);
	}

}
