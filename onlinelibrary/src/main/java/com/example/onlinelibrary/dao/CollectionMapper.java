package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Collection;

public interface CollectionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);
}