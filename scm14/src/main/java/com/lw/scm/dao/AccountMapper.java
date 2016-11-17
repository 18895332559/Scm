package com.lw.scm.dao;


import com.lw.scm.bean.Account;

public interface AccountMapper extends BaseMapper<Account> {


    public Account login(Account account);
}