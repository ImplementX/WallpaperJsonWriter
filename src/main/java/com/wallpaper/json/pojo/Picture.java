package com.wallpaper.json.pojo;

public class Picture {
    private Integer picId;

    private String picName;

    private String picPath;

    private String picDetail;

    private String picStatus;

    private String picTag;

    private String picThumbnail;

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName == null ? null : picName.trim();
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public String getPicDetail() {
        return picDetail;
    }

    public void setPicDetail(String picDetail) {
        this.picDetail = picDetail == null ? null : picDetail.trim();
    }

    public String getPicStatus() {
        return picStatus;
    }

    public void setPicStatus(String picStatus) {
        this.picStatus = picStatus == null ? null : picStatus.trim();
    }

    public String getPicTag() {
        return picTag;
    }

    public void setPicTag(String picTag) {
        this.picTag = picTag == null ? null : picTag.trim();
    }

    public String getPicThumbnail() {
        return picThumbnail;
    }

    public void setPicThumbnail(String picThumbnail) {
        this.picThumbnail = picThumbnail == null ? null : picThumbnail.trim();
    }
}