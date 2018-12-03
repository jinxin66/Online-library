package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Level;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface LevelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKeyWithBLOBs(Level record);

    int updateByPrimaryKey(Level record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);
}