package com.winter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.mapper.UserMessageMapper;
import com.winter.model.UserMessage;
import com.winter.service.IUserMessageService;

@Service
public class UserMessageServiceImpl implements IUserMessageService{

	@Autowired
	UserMessageMapper userMessageMapper;
	
	public int updateUser(UserMessage user) {
		// TODO Auto-generated method stub
		return userMessageMapper.updateUser(user);
	}

	public UserMessage queryUser(String id) {
		// TODO Auto-generated method stub
		return userMessageMapper.queryUserById(id);
	}

	@Override
	public int insertSelective(UserMessage record) {
		// TODO Auto-generated method stub
		return userMessageMapper.insertSelective(record);
	}
	

}
