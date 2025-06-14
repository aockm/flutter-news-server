package com.tockm.entity.po;

import java.io.Serializable;

public class CategoryEntity implements Serializable {
    private String code;
    private String title;

    public CategoryEntity() {
    }

    public CategoryEntity(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
