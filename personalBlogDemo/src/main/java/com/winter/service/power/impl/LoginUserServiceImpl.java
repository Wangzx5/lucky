package com.winter.service.power.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.mapper.power.LoginUserMapper;
import com.winter.model.power.LoginUser;
import com.winter.service.power.ILoginUserService;

@Service
public class LoginUserServiceImpl implements ILoginUserService{

	@Autowired
	LoginUserMapper loginUserMapper;
	
	@Override
	public LoginUser selectByPrimaryKey(String userId) {
		// TODO Auto-generated method stub
		return loginUserMapper.selectByPrimaryKey(userId);
	}

	@Override
	public LoginUser selectByUserName(String userName) {
		// TODO Auto-generated method stub
		return loginUserMapper.selectByUserName(userName);
	}

	@Override
	public int insertSelective(LoginUser record) {
		// TODO Auto-generated method stub
		return loginUserMapper.insertSelective(record);
	}

}
