package com.winter.service;

import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.winter.model.BlogFile;

public interface IBlogFileService {
	
    int insertSelective(BlogFile record);

    BlogFile selectByPrimaryKey(String fileId);

    public JSONObject uploadSimditorImg(MultipartFile file) throws Exception;

}
