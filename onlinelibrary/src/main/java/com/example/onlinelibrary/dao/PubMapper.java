package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Pub;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface PubMapper {
    int deleteByPrimaryKey(String id);

    int insert(Pub record);

    int insertSelective(Pub record);

    Pub selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Pub record);

    int updateByPrimaryKey(Pub record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);
}