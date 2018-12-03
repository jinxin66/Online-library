package com.example.onlinelibrary.service.admin.collection;

import com.example.onlinelibrary.dao.CollectionMapper;
import com.example.onlinelibrary.entity.Collection;
import com.example.onlinelibrary.utils.IDGenerator;
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
public class CollectionService {

    @Value("${PAGE_SIZE}")
    private int PAGE_SIZE;

    @Autowired
    private CollectionMapper mapper;

    public Integer delete(String id){
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer deletebyIds(String[]id){
        Map parmMap = new HashMap();
        parmMap.put("ids",id);
        return mapper.deleteByMap(parmMap);
    }

    public Integer deleteByUserIdAndId(Map<String,Object> map){
        return mapper.deleteByUserIdAndId(map);
    }

    public Integer update(Collection entity){
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer enable(String id){
        Collection entity = new Collection();
        entity.setId(id);
        entity.setStatus(false);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer disable(String id){
        Collection entity = new Collection();
        entity.setId(id);
        entity.setStatus(true);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer save(Collection entity) {
        entity.setId(IDGenerator.generator());
        return mapper.insertSelective(entity);
    }

    public Collection findById(String id){
        return mapper.selectByPrimaryKey(id);
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
