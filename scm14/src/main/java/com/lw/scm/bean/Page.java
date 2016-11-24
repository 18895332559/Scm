package com.lw.scm.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lw on 2016/11/17.
 */
public class Page<T> implements Serializable {
    private static final long serialVersionUID = 337297181251071639L;
    private Integer page;//当前页
    private Integer rows; //页大小
    private Integer totalRecord;//总记录
    private List<T> list;//页面数据列表
    private String keyWord;//查询关键字
    private T paramEntity; //多条件查询
    //需要注意的是：start需要特殊处理
    private Integer start;
    private Map<String, Object> pageMap = new HashMap<String, Object>();

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public T getParamEntity() {
        return paramEntity;
    }

    public void setParamEntity(T paramEntity) {
        this.paramEntity = paramEntity;
    }

    public Integer getStart() {
        start = (page - 1) * rows;
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Map<String, Object> getPageMap() {
        return pageMap;
    }

    public void setPageMap(Map<String, Object> pageMap) {
        this.pageMap = pageMap;
    }

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", rows=" + rows +
                ", totalRecord=" + totalRecord +
                ", list=" + list +
                ", keyWord='" + keyWord + '\'' +
                ", paramEntity=" + paramEntity +
                ", start=" + start +
                ", pageMap=" + pageMap +
                '}';
    }
}
