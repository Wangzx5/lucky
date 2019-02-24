package com.winter.service;

import com.winter.model.UserMessage;

public interface IUserMessageService {

	UserMessage queryUser(String id);
	
	int updateUser(UserMessage user);
	
	int insertSelective(UserMessage record);
}
