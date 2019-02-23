package com.winter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.mapper.BlogCommentMapper;
import com.winter.model.BlogComment;
import com.winter.model.vo.BlogCommentVo;
import com.winter.service.IBlogCommentService;

@Service
public class BlogCommentServiceImpl implements IBlogCommentService {

	@Autowired
	BlogCommentMapper commentMapper;
	
	@Override
	public int insertSelective(BlogComment record) {
		// TODO Auto-generated method stub
		return commentMapper.insertSelective(record);
	}

	@Override
	public List<BlogCommentVo> selectByBlogId(String blogId) {
		// TODO Auto-generated method stub
		return commentMapper.selectByBlogId(blogId);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return commentMapper.deleteByPrimaryKey(id);
	}

}
