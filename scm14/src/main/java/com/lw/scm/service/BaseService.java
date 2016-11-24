package com.lw.scm.service;

import com.lw.scm.bean.Page;
import com.lw.scm.bean.Supplier;

import java.util.List;

/**
 * Created by lw on 2016/11/17.
 */
public interface BaseService<T> {

    //添加实体对象信息到表
    int insert(T entity) throws Exception;

    int update(T entity) throws Exception;

    //根据对象主键查询
    T selectByPk(T entity);

    //根据对象主键删除
    int deleteByPk(T entity) throws Exception;

    //通过数组删除
    Integer deleteList(String[] pks) throws Exception;

    //根据对象主键修改
    int updateByKk(T entity) throws Exception;

    //根据对象动态查询对象列表
    List<T> selectUseDyc(T entity);


    //分页查询
    Page<T> selectPage(Page<T> page);

    //通过多条件分页查询
    Page<T> selectPageUseDyc(Page<T> page);
}
