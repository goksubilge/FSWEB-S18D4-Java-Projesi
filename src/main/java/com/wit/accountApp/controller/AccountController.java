package com.wit.accountApp.controller;


import com.wit.accountApp.dto.AccountResponse;
import com.wit.accountApp.dto.CustomerResponse;
import com.wit.accountApp.entity.Account;
import com.wit.accountApp.entity.Customer;
import com.wit.accountApp.service.AccountService;
import com.wit.accountApp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;
    private CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService, CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }


    @GetMapping("/")
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account find(@PathVariable long id) {
        return  accountService.find(id);

    }

    @PostMapping("/{customerId}")
    public AccountResponse save(@RequestBody Account account, @PathVariable long customerId ){
        Customer customer = customerService.find(customerId);  // customerId den customer 'ı bulmalıyım.
        // errorHandling yazıp find methodunun içinde bu if controlünü yapmam lazımdı, buraya gelmeyecek if kontrolü!
    if (customer != null) {
        customer.getAccountList().add(account);  // bunun için Customer Entity 'ye gidip method ekledim.
        account.setCustomer(customer);
        accountService.save(account);
    } else {
        throw new RuntimeException("No customer found");  // kendi yazdıklarımızda ExtendsRuntimeException dı.
    }
    return new AccountResponse(account.getId(), account.getAccountName(), account.getMoneyAmount(),
            new CustomerResponse(customer.getId(),customer.getEmail(),customer.getSalary()));
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable long id){
        return accountService.delete(id);

    }

}
