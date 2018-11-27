package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(String id);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKeyWithBLOBs(Level record);

    int updateByPrimaryKey(Level record);
}