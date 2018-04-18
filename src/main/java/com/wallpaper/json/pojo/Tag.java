package com.wallpaper.json.pojo;

public class Tag {
    private Integer tagId;

    private String tagName;

    private String tagNumber;

    private String tagPinyin;

    public Integer getTagId() {
        return tagId;
    }

    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName == null ? null : tagName.trim();
    }

    public String getTagNumber() {
        return tagNumber;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber == null ? null : tagNumber.trim();
    }

    public String getTagPinyin() {
        return tagPinyin;
    }

    public void setTagPinyin(String tagPinyin) {
        this.tagPinyin = tagPinyin == null ? null : tagPinyin.trim();
    }
}