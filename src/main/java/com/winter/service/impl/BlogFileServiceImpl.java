package com.winter.service.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.winter.mapper.BlogFileMapper;
import com.winter.model.BlogFile;
import com.winter.service.IBlogFileService;

@Service
public class BlogFileServiceImpl implements IBlogFileService {

	@Autowired
	BlogFileMapper blogFileMapper;
	
	@Override
	public int insertSelective(BlogFile record) {
		// TODO Auto-generated method stub
		return blogFileMapper.insertSelective(record);
	}

	@Override
	public BlogFile selectByPrimaryKey(String fileId) {
		// TODO Auto-generated method stub
		return blogFileMapper.selectByPrimaryKey(fileId);
	}

	/**
	 * 上传文件
	 * @param file
	 * @return
	 * @throws Exception
	 * @author wzx
	 */
	public JSONObject uploadSimditorImg(MultipartFile file) throws Exception {
		if(file == null) {
			throw new Exception("上传失败:文件为空");
		}if(file.getSize() > 30000000) {
			throw new Exception("上传失败：文件大小不能超过30M");
		}
		//获取文件名称
		String fileName = file.getOriginalFilename();
		BlogFile uploadFile = null;
		if(file.getSize() > 0){
			//调用附件上传方法
			try {
				uploadFile = SaveFileFromInputStream(file.getInputStream(), "C:/test", fileName);
			} catch (IOException e) {
				System.out.println("----"+e.getMessage());
				return null;
			}
		}else {
			throw new Exception("上传失败:上传的文件不能为空");
		}
		JSONObject json = new JSONObject();
		try {
            if(uploadFile != null && uploadFile.getFileId() != null){
            	json.put("success", true);
            	json.put("file_path", uploadFile.getFileUrl());
            }else{
            	json.put("success", false);
            }
		} catch (Exception e) {
			e.printStackTrace();
		}
 
        return json;
	}

	private BlogFile SaveFileFromInputStream(InputStream inputStream, String path, String fileName) 
			throws IOException {
		String fileUrl = path + "/" + System.currentTimeMillis() + "_" + fileName ;
		FileOutputStream fs = new FileOutputStream(fileUrl);
		byte[] buffer = new byte[1024 * 1024];
		int byteSum = 0;
		int byteRead = 0;
		while((byteRead = inputStream.read(buffer)) != -1) {
			byteSum += byteRead;
			fs.write(buffer, 0, byteRead);
			fs.flush();
		}
		fs.close();
		inputStream.close();
		//写入数据库文件记录
		String fileId = UUID.randomUUID().toString(); //获取一个UUID作为文件id
//		SimpleDateFormat formDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		BlogFile uploadFile = new BlogFile();
		uploadFile.setFileId(fileId);
		uploadFile.setFileUrl(fileUrl);
		uploadFile.setFileName(fileName);
		uploadFile.setCreateTime(new Date());
		insertSelective(uploadFile);
		return uploadFile;
	}
	
	
}
