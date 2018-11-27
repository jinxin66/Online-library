package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Pub;

public interface PubMapper {
    int deleteByPrimaryKey(String id);

    int insert(Pub record);

    int insertSelective(Pub record);

    Pub selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Pub record);

    int updateByPrimaryKey(Pub record);
}