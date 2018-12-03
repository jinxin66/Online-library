package com.example.onlinelibrary.entity;

public class Category {
    private String id;

    private String categoryName;

    private String categoryCode;

    private String categoryImg;

    private Boolean status;

    private String describption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode == null ? null : categoryCode.trim();
    }

    public String getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryImg(String categoryImg) {
        this.categoryImg = categoryImg == null ? null : categoryImg.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescribption() {
        return describption;
    }

    public void setDescribption(String describption) {
        this.describption = describption == null ? null : describption.trim();
    }
}