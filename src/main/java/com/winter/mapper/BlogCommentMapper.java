package com.winter.mapper;

import java.util.List;

import com.winter.model.BlogComment;
import com.winter.model.vo.BlogCommentVo;

public interface BlogCommentMapper {
    int deleteByPrimaryKey(String id);
    
    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    BlogComment selectByPrimaryKey(String id);
    
    List<BlogCommentVo> selectByBlogId(String BlogId);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);
}