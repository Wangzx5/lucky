package com.winter.service;

import java.util.List;

import com.winter.model.BlogComment;
import com.winter.model.vo.BlogCommentVo;

public interface IBlogCommentService {
	
	int insertSelective(BlogComment record);

    List<BlogCommentVo> selectByBlogId(String blogId);

    int deleteByPrimaryKey(String id);

}
