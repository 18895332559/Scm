package com.lw.scm.dao;

import com.lw.scm.bean.Page;
import com.lw.scm.bean.Supplier;

import java.util.List;

/**
 * Created by lw on 2016/11/16.
 */
public interface BaseMapper<T> {
    //添加单个对象
    public int insert(T entity);

    //修改单个对象
    public int update(T entity);

    //删除单个对象
    public int delete(T entity);

    public T select(T entity);


    //用于分页查询数据集
    List<T> selectPageList(Page<T> page);

    //用户分页查询总记录数
    int selectCount(Page<T> page);


    List<T> selectPageListUseDyc(Page<T> page);

    //多条件查询总记录数
    Integer selectPageCountUseDyc(Page<Supplier> page);

    //通过数组删除
    Integer deleteList(String[] pks);

}
