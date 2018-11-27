package com.example.onlinelibrary.entity;

import java.util.Date;

public class Ticket {
    private String id;

    private String ticketCode;

    private String userId;

    private String borrowRecordId;

    private String bookId;

    private Double ticketFee;

    private Date overTime;

    private Date createTime;

    private Date payTime;

    private Boolean status;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode == null ? null : ticketCode.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getBorrowRecordId() {
        return borrowRecordId;
    }

    public void setBorrowRecordId(String borrowRecordId) {
        this.borrowRecordId = borrowRecordId == null ? null : borrowRecordId.trim();
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public Double getTicketFee() {
        return ticketFee;
    }

    public void setTicketFee(Double ticketFee) {
        this.ticketFee = ticketFee;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}