package com.lw.scm.service;

import com.lw.scm.bean.Account;
import com.lw.scm.bean.Page;
import com.lw.scm.dao.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lw on 2016/11/17.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public int insert(Account entity) throws Exception {
        return 0;
    }

    @Override
    public int update(Account entity) throws Exception {
        return 0;
    }

    @Override
    public Account selectByPk(Account entity) {
        return null;
    }

    @Override
    public int deleteByPk(Account entity) throws Exception {
        return 0;
    }

    @Override
    public Integer deleteList(String[] pks) throws Exception {
        return null;
    }

    @Override
    public int updateByKk(Account entity) throws Exception {
        return 0;
    }

    @Override
    public List<Account> selectUseDyc(Account entity) {
        return null;
    }

    @Override
    public Page<Account> selectPage(Page<Account> page) {
        return null;
    }


    @Override
    public Page<Account> selectPageUseDyc(Page<Account> page) {
        return null;
    }

    @Override
    public Account login(Account account) {
        return accountMapper.login(account);
    }
}
