package com.wit.accountApp.service;

import com.wit.accountApp.entity.Account;
import com.wit.accountApp.entity.Address;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account find(long id);
    Account save(Account account);
    Account delete (long id);
}
