package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Collection;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface CollectionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);

    int deleteByUserIdAndId(Map<String, Object> map);
}