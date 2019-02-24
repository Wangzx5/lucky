package com.winter.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.alibaba.fastjson.JSONObject;
import com.winter.model.BlogContent;
import com.winter.model.UserMessage;
import com.winter.model.power.LoginUser;
import com.winter.model.vo.BlogTitleVo;
import com.winter.service.IBlogContentService;
import com.winter.service.IBlogFileService;
import com.winter.service.IBlogTitleService;
import com.winter.service.IUserMessageService;
import com.winter.service.power.ILoginUserService;

/**
 * 
 * @author mustb
 *
 */
@Controller
@RequestMapping("/personal_blog")
public class BlogBaseController {
	
	@Autowired
	IUserMessageService messageService;
	
	@Autowired
	IBlogFileService blogFileService;
	
	@Autowired
	IBlogContentService blogContentService;
	
	@Autowired
	IBlogTitleService blogTitleService;
	
	@Autowired
	ILoginUserService loginUser;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 	查询用户基本资料
	 * @param id
	 * @return
	 * @throws Exception
	 * @author wzx
	 */
	@ResponseBody
	@RequestMapping("/query_user/{id}")
	public UserMessage queryUser(@PathVariable("id") String id) throws Exception {
		if(id == null || id == "") {
			throw new Exception("用户Id不能为空!");
		}
		logger.info("quer_user by id:" + id);
		return messageService.queryUser(id);
	}
	
	/**
	 * 用户信息存在是更新信息,否则新增
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/update")
	public int updateUser( UserMessage user) throws Exception {
		UserMessage queryUser = queryUser(user.getUserId());
		if(queryUser != null) {
			return messageService.updateUser(user);
		}else {
			return messageService.insertSelective(user);
		}
	}
	
	/**
	 * Simditor图片上传接口
	 * @param fileData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/upload_file")
	public JSONObject uploadFile(MultipartFile fileData) {
		JSONObject json = new JSONObject();
		if(fileData != null) {
			System.out.println("开始上传");
			try {
				json = blogFileService.uploadSimditorImg(fileData);
				System.out.println("file:" + fileData.getOriginalFilename());
			} catch (Exception e) {
				logger.info("上传编辑器图片失败：" + e);
	//			System.out.println("上传编辑器图片失败：" + e.toString());
			}
		}
		return json;
	}
	
	/**
	 * 新增博客并添加标题内容
	 * @param content
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@Transactional
	@RequestMapping("/save_bLog")
	public String saveBlog(@PathParam("content")String content, @PathParam("userId")String userId) throws Exception {
		if(content == "" || userId == "") {
			 throw new Exception("内容及用户id不能为空");
		}
		BlogContent blogContent = new BlogContent();
		blogContent.setBlogId(UUID.randomUUID().toString());
		blogContent.setContent(content);
		blogContent.setCreateUserId(userId);
		blogContent.setCreateTime(new Date());
		int insertSelective = blogContentService.insertSelective(blogContent); //新增博客内容
		blogTitleService.saveBlogTitle(blogContent);  //保存标题信息
		
		return String.valueOf(insertSelective);
	}
	
	/**
	 * 	查询博客标题展示
	 * 		由于前端展示问题,目前先只展示一条
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/query_title")
	public BlogTitleVo queryBlogTitle(){
		List<BlogTitleVo> blogTitleVoList = blogTitleService.selectBlogTitle();
		BlogTitleVo blogTitleVo = blogTitleVoList.get(0);
		//将用户真实名称设置进去
		String authorId = blogTitleVo.getAuthor();
		LoginUser user = loginUser.selectByPrimaryKey(authorId);
		blogTitleVo.setUserName(user.getUserName());
		return blogTitleVo;
	}
	
	
	/**
	 *	根据blog_id查询博客内容及标题
	 * 
	 * @param blogId
	 * @return
	 * @throws Exception 
	 */
	@ResponseBody
	@RequestMapping("/query_blog/{blog_id}")
	public BlogContent queryBlog(@PathVariable("blog_id") String blogId) throws Exception {
		if(blogId == null || blogId == "") {
			throw new Exception("blogId不能为空");
		}
		BlogContent blogContent = blogContentService.selectByPrimaryKey(blogId);
		return blogContent;
	}

		
}
