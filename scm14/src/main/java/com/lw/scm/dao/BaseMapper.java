package com.lw.scm.dao;

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

}
