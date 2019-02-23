package com.winter.model;

import java.util.Date;

public class BlogTitle {
    private String blogId;

    private String blogTitle;

    private String titleImgId;

    private String author;

    private Date createTime;

    private Date updateTime;

    public String getBlogId() {
        return blogId;
    }

    public void setBlogId(String blogId) {
        this.blogId = blogId == null ? null : blogId.trim();
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getTitleImgId() {
        return titleImgId;
    }

    public void setTitleImgId(String titleImgId) {
        this.titleImgId = titleImgId == null ? null : titleImgId.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}