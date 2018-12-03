package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.Ticket;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface TicketMapper {
    int deleteByPrimaryKey(String id);

    int insert(Ticket record);

    int insertSelective(Ticket record);

    Ticket selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Ticket record);

    int updateByPrimaryKey(Ticket record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);
}