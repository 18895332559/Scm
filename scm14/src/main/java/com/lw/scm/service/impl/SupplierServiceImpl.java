package com.lw.scm.service.impl;

import com.lw.scm.bean.Page;
import com.lw.scm.bean.Supplier;
import com.lw.scm.dao.SupplierMapper;
import com.lw.scm.service.BaseService;
import com.lw.scm.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lw on 2016/11/16.
 */
@Service("supplierService")
public class SupplierServiceImpl extends BaseServiceImpl<Supplier> implements SupplierService {


    /**
     @Autowired private SupplierMapper supplierMapper;

     @Override public int insert(Supplier supplier) {
     return supplierMapper.insert(supplier);
     }

     @Override public int update(Supplier entity) throws Exception {
     return supplierMapper.update(entity);
     }

     @Override public Supplier selectByPk(Supplier entity) {
     return null;
     }

     @Override public int deleteByPk(Supplier entity) throws Exception {
     return 0;
     }

     @Override public Integer deleteList(String[] pks) {
     return supplierMapper.deleteList(pks);
     }

     @Override public int updateByKk(Supplier entity) throws Exception {
     return 0;
     }

     @Override public List<Supplier> selectUseDyc(Supplier entity) {
     return null;
     }

     @Override public Page<Supplier> selectPage(Page<Supplier> page) {
     //设置查询集合
     page.setList(supplierMapper.selectPageList(page));
     //设置个数
     page.setTotalRecord(supplierMapper.selectCount(page));
     return page;
     }

     @Override public Page<Supplier> selectPageUseDyc(Page<Supplier> page) {
     page.setList(supplierMapper.selectPageList(page));
     page.setTotalRecord(supplierMapper.selectPageCountUseDyc(page));
     return page;
     }*/
}
