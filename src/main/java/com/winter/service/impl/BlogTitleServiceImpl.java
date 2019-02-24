package com.winter.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.winter.mapper.BlogTitleMapper;
import com.winter.model.BlogContent;
import com.winter.model.BlogTitle;
import com.winter.model.vo.BlogTitleVo;
import com.winter.service.IBlogTitleService;

@Service
public class BlogTitleServiceImpl implements IBlogTitleService {

	@Autowired
	BlogTitleMapper blogTitleMapper;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public int insertSelective(BlogTitle record) {
		// TODO Auto-generated method stub
		return blogTitleMapper.insertSelective(record);
	}

	@Override
	public BlogTitle selectByBlogId(String blogId) {
		// TODO Auto-generated method stub
		return blogTitleMapper.selectByBlogId(blogId);
	}
	
	/**
	 * 添加到blog标题内容
	 */
	@Override
	public int saveBlogTitle(BlogContent blogContent) {
		String content = blogContent.getContent();
		String substring = "";
		String imgUrl = "";
		if(content != null) {
			//获取标题内容
			try {
				int indexOf1 = content.indexOf("<h");
				int indexOf2 = content.indexOf(">", indexOf1);
				int indexOf3 = content.indexOf("</h", indexOf2);
				substring = content.substring(indexOf2 + 1, indexOf3);
			} catch (Exception e) {
				log.error("标题获取失败: " + e);
			}
			//获取图片地址
			try {
				int img1 = content.indexOf("<img");
				int img2 = content.indexOf("src=\"", img1);
				int img3 = content.indexOf("\"", img2 + 5);
				imgUrl = content.substring(img2 + 5, img3);
			} catch (Exception e) {
				log.error("图片地址获取失败: " + e);
			}
		}
	
		String blogId = blogContent.getBlogId();
		Date createTime = blogContent.getCreateTime();
		BlogTitle blogTitle = new BlogTitle();
		blogTitle.setBlogTitle(substring);
		blogTitle.setBlogId(blogId);
		blogTitle.setAuthor(blogContent.getCreateUserId());
		blogTitle.setCreateTime(createTime);
		blogTitle.setTitleImgId(imgUrl);
		return insertSelective(blogTitle);
	}

	/**
	 * 	根据创建时间查询最新一条
	 */
	@Override
	public List<BlogTitleVo> selectBlogTitle() {
		// TODO Auto-generated method stub
		return blogTitleMapper.selectBlogTitle();
	}

}
