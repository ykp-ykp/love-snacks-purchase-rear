package com.ykp.snacks.Service.Impl;

import com.ykp.snacks.Dao.AccountDao;
import com.ykp.snacks.Service.AccountService;
import com.ykp.snacks.domain.Account;
import com.ykp.snacks.domain.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Service("accountService")/*这里需要加引用名，否则@Autowired的时候会找不到*/
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("业务层--查询所有的账户信息");
        //下面调用dao的方法
        return accountDao.findAll();

    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层--保存账户信息");
        accountDao.saveAccount(account);
    }

    @Override
    public void saveUser(user user) {
        System.out.println("业务层--保存用户信息");
        accountDao.saveUser(user);
    }

}
