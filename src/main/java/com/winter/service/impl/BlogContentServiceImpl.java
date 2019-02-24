package com.winter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.mapper.BlogContentMapper;
import com.winter.model.BlogContent;
import com.winter.model.vo.BlogContentVo;
import com.winter.service.IBlogContentService;

@Service
public class BlogContentServiceImpl implements IBlogContentService {

	@Autowired
	BlogContentMapper blogContentMapper;
	
	@Override
	public int insertSelective(BlogContent record) {
		// TODO Auto-generated method stub
		return blogContentMapper.insertSelective(record);
	}

	@Override
	public BlogContent selectByPrimaryKey(String blogId) {
		// TODO Auto-generated method stub
		return blogContentMapper.selectByPrimaryKey(blogId);
	}

	@Override
	public int updateByPrimaryKeySelective(BlogContent record) {
		// TODO Auto-generated method stub
		return blogContentMapper.updateByPrimaryKeySelective(record);
	}

}
