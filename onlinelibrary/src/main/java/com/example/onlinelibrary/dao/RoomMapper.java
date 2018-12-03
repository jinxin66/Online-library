package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Room;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface RoomMapper {
    int deleteByPrimaryKey(String id);

    int insert(Room record);

    int insertSelective(Room record);

    Room selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKeyWithBLOBs(Room record);

    int updateByPrimaryKey(Room record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);
}