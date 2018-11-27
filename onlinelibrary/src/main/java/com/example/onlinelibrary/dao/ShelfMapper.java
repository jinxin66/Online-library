package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Shelf;

public interface ShelfMapper {
    int deleteByPrimaryKey(String id);

    int insert(Shelf record);

    int insertSelective(Shelf record);

    Shelf selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Shelf record);

    int updateByPrimaryKeyWithBLOBs(Shelf record);

    int updateByPrimaryKey(Shelf record);
}