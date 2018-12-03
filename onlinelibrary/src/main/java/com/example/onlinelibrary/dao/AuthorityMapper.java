package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Authority;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface AuthorityMapper {
    int deleteByPrimaryKey(String id);

    int insert(Authority record);

    int insertSelective(Authority record);

    Authority selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Authority record);

    int updateByPrimaryKey(Authority record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);
}