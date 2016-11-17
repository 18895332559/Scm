package com.lw.scm.service.impl;

import com.lw.scm.bean.Supplier;
import com.lw.scm.dao.SupplierMapper;
import com.lw.scm.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lw on 2016/11/16.
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    public int insert(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    @Override
    public Supplier selectByPk(Supplier entity) {
        return null;
    }

    @Override
    public int deleteByPk(Supplier entity) throws Exception {
        return 0;
    }

    @Override
    public int updateByKk(Supplier entity) throws Exception {
        return 0;
    }

    @Override
    public List<Supplier> selectUseDyc(Supplier entity) {
        return null;
    }
}
