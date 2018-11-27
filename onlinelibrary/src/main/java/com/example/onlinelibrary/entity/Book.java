package com.example.onlinelibrary.entity;

import java.util.Date;

public class Book {
    private String id;

    private String bookCode;

    private String bookIsbn;

    private String bookName;

    private String bookWriter;

    private String bookPublish;

    private String bookVersion;

    private Double bookScore;

    private Double bookPrice;

    private String bookDescription;

    private Boolean status;

    private Date lastBorrowedTime;

    private String lastBorrowerId;

    private String locationId;

    private Double rate;

    private String describption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode == null ? null : bookCode.trim();
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn == null ? null : bookIsbn.trim();
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public void setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter == null ? null : bookWriter.trim();
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish == null ? null : bookPublish.trim();
    }

    public String getBookVersion() {
        return bookVersion;
    }

    public void setBookVersion(String bookVersion) {
        this.bookVersion = bookVersion == null ? null : bookVersion.trim();
    }

    public Double getBookScore() {
        return bookScore;
    }

    public void setBookScore(Double bookScore) {
        this.bookScore = bookScore;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookDescription() {
        return bookDescription;
    }

    public void setBookDescription(String bookDescription) {
        this.bookDescription = bookDescription == null ? null : bookDescription.trim();
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getLastBorrowedTime() {
        return lastBorrowedTime;
    }

    public void setLastBorrowedTime(Date lastBorrowedTime) {
        this.lastBorrowedTime = lastBorrowedTime;
    }

    public String getLastBorrowerId() {
        return lastBorrowerId;
    }

    public void setLastBorrowerId(String lastBorrowerId) {
        this.lastBorrowerId = lastBorrowerId == null ? null : lastBorrowerId.trim();
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId == null ? null : locationId.trim();
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getDescribption() {
        return describption;
    }

    public void setDescribption(String describption) {
        this.describption = describption == null ? null : describption.trim();
    }
}