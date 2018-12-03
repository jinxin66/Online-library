package com.example.onlinelibrary.dao;

import com.example.onlinelibrary.entity.User;
import flybear.hziee.core.sql.Row;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    User selectByWechatId(String wechatId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int deleteByMap(Map<String, Object> map);

    List<Row> selectByMap(Map<String, Object> map);

    int countByMap(Map<String, Object> map);

    User selectByUserName(String username);

    List<Row> selectByRoleId(String roleId);
}