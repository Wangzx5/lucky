package com.winter.mapper;

import com.winter.model.BlogContent;
import com.winter.model.vo.BlogContentVo;

public interface BlogContentMapper {
    int deleteByPrimaryKey(String blogId);

    int insert(BlogContent record);

    int insertSelective(BlogContent record);

    BlogContent selectByPrimaryKey(String blogId);

    int updateByPrimaryKeySelective(BlogContent record);

    int updateByPrimaryKeyWithBLOBs(BlogContent record);

    int updateByPrimaryKey(BlogContent record);
}