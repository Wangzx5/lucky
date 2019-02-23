package com.winter.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.util.StringUtil;
import com.winter.model.BlogComment;
import com.winter.model.power.LoginUser;
import com.winter.model.vo.BlogCommentVo;
import com.winter.service.IBlogCommentService;
import com.winter.service.power.ILoginUserService;

@Controller
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	IBlogCommentService blogCommentService;
	
	@Autowired
	ILoginUserService iloginUserService;

	private Logger  logger = LoggerFactory.getLogger(this.getClass()); 
	
	/**
	 * 查询评论
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/select_comment/{blogId}")
	public List<BlogCommentVo> selectByBlogId(@PathVariable("blogId")String blogId){
		List<BlogCommentVo> selectByBlogId = blogCommentService.selectByBlogId(blogId);
		for (BlogCommentVo blogCommentVo : selectByBlogId) {
			LoginUser user = iloginUserService.selectByPrimaryKey(blogCommentVo.getUserId());
			blogCommentVo.setUserName(user.getUserName());
		}
		
		return selectByBlogId;
	}
	
	/**
	 * 新增评论
	 * @param blogComment
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/saveComment")
	public int saveComment(String blogId, String commentContent, String userId) {
		BlogComment blogComment = new BlogComment();
		if(StringUtil.isNotEmpty(commentContent)) {
			blogComment.setId(UUID.randomUUID().toString());
			blogComment.setCommentContent(commentContent);
			blogComment.setUserId(userId);
			blogComment.setBlogId(blogId);
			blogComment.setCreateTime(new Date());
			logger.info("新增评论:" + blogComment.toString());
		}
		
		return blogCommentService.insertSelective(blogComment);
	}
	
	/**
	 * 删除评论
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/deleteComment/{id}")
	public int deleteComment(@PathVariable("id")String id) {
		
		return blogCommentService.deleteByPrimaryKey(id);
	}
	
	
	
	
}
