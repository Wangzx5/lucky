package com.winter.service.power;

import com.winter.model.power.LoginUser;

public interface ILoginUserService {

	LoginUser selectByPrimaryKey(String userId);
	
    LoginUser selectByUserName(String userName);
    
    int insertSelective(LoginUser record);

	
}
