package com.example.onlinelibrary.service.bookManager;

import com.example.onlinelibrary.dao.BookMapper;
import com.example.onlinelibrary.dao.CategoryMapper;
import com.example.onlinelibrary.entity.Category;
import com.example.onlinelibrary.utils.Constant;
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
public class CategoryService {

    @Value("${PAGE_SIZE}")
    private int PAGE_SIZE;

    @Autowired
    private CategoryMapper mapper;
    @Autowired
    private BookMapper bookMapper;

    public Integer delete(String id){
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer deletebyIds(String[]ids){
        Map parmMap = new HashMap();
        parmMap.put("ids",ids);

        if(!canDeleteCategoty(ids) || mapper.deleteByMap(parmMap) != ids.length){
            throw new RuntimeException("该分类下存在图书，请处理产品后重试！");
        }
        return Constant.SUCCESS_INT;
    }

    public Integer enable(String id){
        Category entity = new Category();
        entity.setId(id);
        entity.setStatus(false);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer disable(String id){
        Category entity = new Category();
        entity.setId(id);
        entity.setStatus(true);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer update(Category entity){
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer save(Category entity) {
        entity.setId(IDGenerator.generator());
        return mapper.insertSelective(entity);
    }

    public Category findById(String id){
        return mapper.selectByPrimaryKey(id);
    }

    public List<Row> findAll(){
        return mapper.selectAll();
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

    private boolean canDeleteCategoty(String []ids){
        Map parmMap = new HashMap();
        parmMap.put("categoryIds",ids);
        return bookMapper.countByMap(parmMap) == 0;
    }
}
