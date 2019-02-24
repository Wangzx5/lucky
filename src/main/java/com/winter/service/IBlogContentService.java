package com.winter.service;

import com.winter.model.BlogContent;

public interface IBlogContentService {

    int insertSelective(BlogContent record);

    BlogContent selectByPrimaryKey(String blogId);

    int updateByPrimaryKeySelective(BlogContent record);

	
}
