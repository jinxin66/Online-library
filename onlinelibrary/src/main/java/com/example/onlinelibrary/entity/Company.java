package com.example.onlinelibrary.entity;

public class Company {
    private String id;

    private String categoryName;

    private String categoryCode;

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