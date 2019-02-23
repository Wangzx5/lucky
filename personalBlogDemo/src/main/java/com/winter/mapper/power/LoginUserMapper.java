package com.winter.mapper.power;

import com.winter.model.power.LoginUser;

public interface LoginUserMapper {
    int deleteByPrimaryKey(String userId);

    int insert(LoginUser record);

    int insertSelective(LoginUser record);

    LoginUser selectByPrimaryKey(String userId);
    
    LoginUser selectByUserName(String userName);

    int updateByPrimaryKeySelective(LoginUser record);

    int updateByPrimaryKey(LoginUser record);
}