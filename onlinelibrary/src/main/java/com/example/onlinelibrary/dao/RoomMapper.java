package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Room;

public interface RoomMapper {
    int deleteByPrimaryKey(String id);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKeyWithBLOBs(Room record);

    int updateByPrimaryKey(Room record);
}