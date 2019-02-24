package com.winter.mapper;

import com.winter.model.BlogFile;

public interface BlogFileMapper {
    int deleteByPrimaryKey(String fileId);

    int insert(BlogFile record);

    int insertSelective(BlogFile record);

    BlogFile selectByPrimaryKey(String fileId);

    int updateByPrimaryKeySelective(BlogFile record);

    int updateByPrimaryKey(BlogFile record);
}