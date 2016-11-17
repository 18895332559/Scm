package com.lw.scm.service;

import com.lw.scm.bean.Account;

/**
 * Created by lw on 2016/11/17.
 */
public interface AccountService extends BaseService<Account> {

    public Account login(Account account);
}
