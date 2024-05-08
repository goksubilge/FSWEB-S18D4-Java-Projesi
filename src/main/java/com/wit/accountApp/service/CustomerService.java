package com.wit.accountApp.service;

import com.wit.accountApp.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer find(long id);
    Customer save(Customer customer);
    Customer delete(long id);
}
