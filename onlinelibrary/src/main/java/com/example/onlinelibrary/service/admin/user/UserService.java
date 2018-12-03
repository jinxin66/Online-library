package com.example.onlinelibrary.service.admin.user;

import com.example.onlinelibrary.dao.UserMapper;
import com.example.onlinelibrary.entity.User;
import com.example.onlinelibrary.utils.IDGenerator;
import com.example.onlinelibrary.utils.Md5Util;
import com.example.onlinelibrary.utils.Page;

import flybear.hziee.core.sql.Row;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService {

    @Value("${PAGE_SIZE}")
    private int PAGE_SIZE;

    @Autowired
    private UserMapper mapper;

    public Integer delete(String id){
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer deletebyIds(String[]id){
        Map parmMap = new HashMap();
        parmMap.put("ids",id);
        return mapper.deleteByMap(parmMap);
    }

    public Integer update(User entity){
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer enable(String id){
        User entity = new User();
        entity.setId(id);
        entity.setStatus(false);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer disable(String id){
        User entity = new User();
        entity.setId(id);
        entity.setStatus(true);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer save(User entity) {
        entity.setId(IDGenerator.generator());
        entity.setPassword(Md5Util.getMD5(entity.getPassword()));
        return mapper.insertSelective(entity);
    }

    public User findById(String id){
        return mapper.selectByPrimaryKey(id);
    }

    public User findByWechatId(String wechatId){
        return mapper.selectByWechatId(wechatId);
    }

    public User findByUserName(String username){
        return mapper.selectByUserName(username);
    }

    public List<Row> findByRoleId(String roleId){
        return mapper.selectByRoleId(roleId);
    }

    public List<Row> findByMap(Map<String,Object> map){
        return mapper.selectByMap(map);
    }

    public Page findByMap(Map<String,Object> parmMap, Integer nowPage){
        if(nowPage == null) nowPage = 1;
        parmMap.put("start",(nowPage-1)*PAGE_SIZE);
        parmMap.put("end",PAGE_SIZE);
        return new Page(findByMap(parmMap),mapper.countByMap(parmMap),nowPage,PAGE_SIZE);
    }
}
