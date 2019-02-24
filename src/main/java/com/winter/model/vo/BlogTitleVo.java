package com.winter.model.vo;

import com.winter.model.BlogTitle;

public class BlogTitleVo extends BlogTitle{
	
	private String userName;

	
	
	public BlogTitleVo() {
	}
	
	public BlogTitleVo(BlogTitle blogTitle) {
		this();
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	

}
