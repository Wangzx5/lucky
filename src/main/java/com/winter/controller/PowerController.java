package com.winter.controller;


import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.winter.model.power.LoginUser;
import com.winter.service.power.ILoginUserService;


@Controller
@RequestMapping("/power_blog")
public class PowerController {

	@Autowired
	ILoginUserService iloginUser;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 用户登录
	 * @param userName
	 * @param password
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/login")
	public LoginUser login(String userName,String password) {
		if(userName != null && password != null) {
			LoginUser loginUser = iloginUser.selectByUserName(userName);
			if(loginUser != null && password.equals(loginUser.getUserPassword())) {
	//			Cookie cookie = new Cookie("login_user", JSONObject.toJSONString(loginUser));
				logger.info("登录成功:" + userName);
//				System.out.println("登录成功:" + userName);
				return loginUser;
			}
		}
		return null;
	}
	
	/**
	 * 	注册新用户
	 * @param loginUser
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/register")
	public int register(LoginUser loginUser) {
		if(loginUser != null) {
			String userName = loginUser.getUserName();
			String password = loginUser.getUserPassword();
			if(StringUtil.isNotEmpty(userName) && StringUtil.isNotEmpty(password)) {
				//查询用户名是否注册
				LoginUser selectByUserName = iloginUser.selectByUserName(userName);
				if(selectByUserName == null) {
					loginUser.setUserId(UUID.randomUUID().toString());
					logger.info("注册新用户:" + loginUser.toString());
					return iloginUser.insertSelective(loginUser);
				}else {
					return 2;
				}
			}
		}	
		return 0;
	}
	
	
}
