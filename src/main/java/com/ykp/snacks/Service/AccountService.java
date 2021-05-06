package com.ykp.snacks.Service;

import com.ykp.snacks.domain.Account;
import com.ykp.snacks.domain.user;

import java.util.List;


public interface AccountService {
    public List<Account> findAll();
    public void saveAccount(Account account);
    public void saveUser(user user);
}
