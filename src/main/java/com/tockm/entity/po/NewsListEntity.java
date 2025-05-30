package com.tockm.entity.po;

import java.io.Serializable;

public class NewsListEntity implements Serializable {

    String categoryCode;
    String channelCode;
    String tag;
    String keyword;

    public NewsListEntity() {
    }

    public NewsListEntity(String categoryCode, String channelCode, String tag, String keyword) {
        this.categoryCode = categoryCode;
        this.channelCode = channelCode;
        this.tag = tag;
        this.keyword = keyword;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
