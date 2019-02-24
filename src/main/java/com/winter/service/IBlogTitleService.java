package com.winter.service;

import java.util.List;

import com.winter.model.BlogContent;
import com.winter.model.BlogTitle;
import com.winter.model.vo.BlogTitleVo;

public interface IBlogTitleService {

	int saveBlogTitle(BlogContent blogContent);
	
	int insertSelective(BlogTitle record);
	
	BlogTitle selectByBlogId(String blogId);
	
    List<BlogTitleVo> selectBlogTitle();
	
}
