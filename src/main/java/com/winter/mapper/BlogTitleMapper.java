package com.winter.mapper;

import java.util.List;

import com.winter.model.BlogTitle;
import com.winter.model.vo.BlogTitleVo;

public interface BlogTitleMapper {
    int insert(BlogTitle record);

    int insertSelective(BlogTitle record);
    
    BlogTitle selectByBlogId(String blogId);
    
    List<BlogTitleVo> selectBlogTitle();
}