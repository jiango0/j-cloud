package com.jzc.spring.cloud.entity;

public class Comment {

    public Comment() {

    }

    public Comment(Long kid, Long infoId, Long topId, Long parentId, String content) {
        this.kid = kid;
        this.infoId = infoId;
        this.topId = topId;
        this.parentId = parentId;
        this.content = content;
    }

    private Long kid;

    /**
     * 资源id
     */
    private  Long infoId;

    /**
     * 评论id
     */
    private  Long topId;

    /**
     * 父级评论ID（暂时没有地方用到）
     */
    private  Long parentId;

    private String content;

    public Long getKid() {
        return kid;
    }

    public void setKid(Long kid) {
        this.kid = kid;
    }

    public Long getInfoId() {
        return infoId;
    }

    public void setInfoId(Long infoId) {
        this.infoId = infoId;
    }

    public Long getTopId() {
        return topId;
    }

    public void setTopId(Long topId) {
        this.topId = topId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
