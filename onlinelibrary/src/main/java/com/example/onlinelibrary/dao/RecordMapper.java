package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Record;

public interface RecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}