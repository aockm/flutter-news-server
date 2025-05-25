package com.tockm.entity.vo;

import java.io.Serializable;
import java.util.List;

public class UserInfoVo implements Serializable {

    private static final Long serialVersionUID = 1L;



    private String accessToken;

    private String displayName;

    private List<String> channels;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<String> getChannels() {
        return channels;
    }

    public void setChannels(List<String> channels) {
        this.channels = channels;
    }
}
