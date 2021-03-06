package com.example.onlinelibrary.service.bookManager;

import com.example.onlinelibrary.dao.BookMapper;
import com.example.onlinelibrary.dao.RecordMapper;
import com.example.onlinelibrary.entity.Book;
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
public class BookService {

    @Value("${PAGE_SIZE}")
    private int PAGE_SIZE;

    @Autowired
    private BookMapper mapper;
    @Autowired
    private RecordMapper recordMapper;

    public Integer delete(String id){
        return mapper.deleteByPrimaryKey(id);
    }

    public Integer deletebyIds(String[]ids){
        Map parmMap = new HashMap();
        parmMap.put("ids",ids);

        if(!canDeleteBook(ids) || mapper.deleteByMap(parmMap) != ids.length){
            throw new RuntimeException("部分图书不可删除！");
        }
        return Constant.SUCCESS_INT;
    }

    public Integer enable(String id){
        Book entity = new Book();
        entity.setId(id);
        entity.setStatus(0);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer disable(String id){
        Book entity = new Book();
        entity.setId(id);
        entity.setStatus(1);
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer update(Book entity){
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public Integer save(Book entity) {
        entity.setId(IDGenerator.generator());
        return mapper.insertSelective(entity);
    }

    public Book findById(String id){
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

    private boolean canDeleteBook(String []ids){
        Map parmMap = new HashMap();
        parmMap.put("categoryIds",ids);
        return recordMapper.countByMap(parmMap) == 0;
    }
    public List<Row> getDetailsByMap(Map<String,Object> map){
        return mapper.selectDetailsByMap(map);
    }
}
