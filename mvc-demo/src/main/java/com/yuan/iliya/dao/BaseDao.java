package com.yuan.iliya.dao;

import java.io.Serializable;
import java.util.List;

/**
 * All Rights Reserved, Designed By Iliya Kaslana
 * Copyright ©2018
 * 基本的增删改查类
 * @author Iliya Kaslana
 * @version 1.0
 * @date 2018/9/16 20:34
 * @since 1.8
 */

public interface BaseDao<T> {

    /**
     * 向数据库插入一条记录
     * @param t 插入的实体对象
     */
    void insert(T t);

    /**
     * 向数据库更新一条记录
     * @param t 更新的实体对象
     */
    void update(T t);

    /**
     * 根据id删除数据库一条记录
     * @param id 数据id
     */
    void delete(Serializable id);

    /**
     * 根据id查找数据库一条记录
     * @param id 数据id
     * @return 对应的实体对象
     */
    T findById(Serializable id);

    /**
     * 查找实体对应的所有对象
     * @return 对象List
     */
    List<T> findAll();
}


