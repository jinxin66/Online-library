package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Shelf;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface ShelfMapper {
    int deleteByPrimaryKey(String id);

    int insert(Shelf record);

    int insertSelective(Shelf record);

    Shelf selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Shelf record);

    int updateByPrimaryKeyWithBLOBs(Shelf record);

    int updateByPrimaryKey(Shelf record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);
}