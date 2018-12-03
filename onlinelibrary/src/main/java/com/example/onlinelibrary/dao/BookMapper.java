package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Book;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface BookMapper {
    int deleteByPrimaryKey(String id);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);

    List<Row> selectDetailsByMap(Map<String, Object> map);
}