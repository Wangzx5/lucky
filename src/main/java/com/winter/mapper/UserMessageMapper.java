package com.winter.mapper;

import com.winter.model.UserMessage;

public interface UserMessageMapper {
    int insert(UserMessage record);

    int insertSelective(UserMessage record);
    
    int updateUser(UserMessage user);
    
    UserMessage queryUserById(String id);
}