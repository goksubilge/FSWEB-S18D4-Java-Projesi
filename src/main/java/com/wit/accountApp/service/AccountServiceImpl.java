package com.wit.accountApp.service;

import com.wit.accountApp.entity.Account;
import com.wit.accountApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account find(long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        if(optionalAccount.isPresent()){
            return optionalAccount.get();
        }
        //TODO throw exception
        return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account delete(long id) {
        Account account = find(id);
        if(account!= null){
            accountRepository.delete(account);
        }
        //TODO throw exception
        return null;
    }
}
