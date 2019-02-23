package com.winter.service.power.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.mapper.power.RoleUserMapper;
import com.winter.model.power.RoleUser;
import com.winter.service.power.IRoleUserService;

@Service
public class RoleUserServiceImpl implements IRoleUserService{

	@Autowired
	RoleUserMapper roleUserMapper;
	
	@Override
	public RoleUser selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return roleUserMapper.selectByPrimaryKey(id);
	}

}
