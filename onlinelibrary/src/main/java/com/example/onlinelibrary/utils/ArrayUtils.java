package com.example.onlinelibrary.utils;

import flybear.hziee.core.sql.Row;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class description
 *
 * @version 1.0.0, 18/05/8
 */
public class ArrayUtils {

    //将有序数组转化成Map数组 取field作为Map的key,数组元素作为Map的value
    public static Map index(List<?> arrayList, String field) {

        Map map = new HashMap();
        for (Object object : arrayList) {
            try {
                Map<String, Object> row = objectToMap(object);
                if (row.containsKey(field))
                    map.put((String) row.get(field), row);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    //将List<Row>变成以field字段为分支的树
    //如:当field为（甜品）
    //      |-- 奶茶
    //甜品--|-- 蛋糕
    //      |-- 面包
    public static List tree(List<?> arrayList, String field) {
        List list = new ArrayList();
        Map map = mapTree(arrayList, field);
        for (Object key : map.keySet()) {
            Map fields = new HashMap();
            fields.put("key", (String) key);
            fields.put("value", map.get(key));
            list.add(fields);
        }
        return list;
    }

    //将List<Row>变成以field字段为分支的树
    //如:当field为（甜品）
    //      |-- 奶茶
    //甜品--|-- 蛋糕
    //      |-- 面包
    public static Map mapTree(List<?> arrayList, String field) {
        Map map = new HashMap();
        for (Object object : arrayList) {
            try {
                Map<String, Object> row = objectToMap(object);
                if (map.containsKey((String) row.get(field))) {
                    List l = (ArrayList) map.get((String) row.get(field));
                    l.add(row);
                    map.put((String) row.get(field), l);
                } else {
                    List l = new ArrayList();
                    l.add(row);
                    map.put((String) row.get(field), l);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    //将每条Row中的 field字段数据取出生成一个List
    public static List column(List<?> arrayList, String field) {
        List<String> list = new ArrayList<String>();
        for (Object object : arrayList) {
            try {
                Map<String, Object> row = objectToMap(object);
                if (row.containsKey(field))
                    if(!list.contains((String) row.get(field)))
                        list.add((String) row.get(field));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        if(obj instanceof Row) return (Row)obj;
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        System.out.println(clazz);
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }
}
