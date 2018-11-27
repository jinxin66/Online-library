package com.example.onlinelibrary.entity;

public class Room {
    private String id;

    private String name;

    private String roomCode;

    private Byte status;

    private String address;

    private byte[] describption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public byte[] getDescribption() {
        return describption;
    }

    public void setDescribption(byte[] describption) {
        this.describption = describption;
    }
}