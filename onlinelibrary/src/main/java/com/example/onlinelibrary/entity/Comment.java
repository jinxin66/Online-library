package com.example.onlinelibrary.entity;

import java.util.Date;

public class Comment {
    private String id;

    private Integer category;

    private String fromId;

    private String toId;

    private Double commentScore;

    private String commentWord;

    private Date createTime;

    private Integer supportNum;

    private Boolean status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId == null ? null : fromId.trim();
    }

    public String getToId() {
        return toId;
    }

    public void setToId(String toId) {
        this.toId = toId == null ? null : toId.trim();
    }

    public Double getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(Double commentScore) {
        this.commentScore = commentScore;
    }

    public String getCommentWord() {
        return commentWord;
    }

    public void setCommentWord(String commentWord) {
        this.commentWord = commentWord == null ? null : commentWord.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getSupportNum() {
        return supportNum;
    }

    public void setSupportNum(Integer supportNum) {
        this.supportNum = supportNum;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}