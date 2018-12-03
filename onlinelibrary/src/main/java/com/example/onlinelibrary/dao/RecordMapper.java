package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Record;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface RecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);
}