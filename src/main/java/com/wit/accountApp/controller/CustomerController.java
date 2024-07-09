package com.wit.accountApp.controller;

import com.wit.accountApp.dto.CustomerResponse;
import com.wit.accountApp.entity.Customer;
import com.wit.accountApp.service.CustomerService;
import com.wit.accountApp.util.EntityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<CustomerResponse> findAll() {
        return EntityConverter.findResults(customerService.findAll());
        // List<Customer> dönmeyecek, <CustomerResponse> dönecek. util --> EntityConverter eklemesi yapıyoruz.
    }

    @GetMapping("/{id}")
    public CustomerResponse find(@PathVariable long id) {
        return  EntityConverter.findResult(customerService.find(id));
        // util --> EntityConverter eklemesi yapıyoruz.
    }

    @PostMapping("/")
    public CustomerResponse save(@RequestBody Customer customer){
        return EntityConverter.findResult(customerService.save(customer));
        // util --> EntityConverter eklemesi yapıyoruz.
    }

    @PutMapping("/{id}")
    public CustomerResponse save(@RequestBody Customer customer, @PathVariable long id ){
        Customer foundCustomer = customerService.find(id);
        if (foundCustomer != null) {
            customer.setId(id);
            return EntityConverter.findResult(customerService.save(customer));
            // util --> EntityConverter eklemesi yapıyoruz.
        }
        // TODO throw exception
        return null;
    }

    @DeleteMapping("/{id}")
    public CustomerResponse delete(@PathVariable long id){
        return EntityConverter.findResult(customerService.delete(id));
        // util --> EntityConverter eklemesi yapıyoruz.
    }

}

// ilk önce addressCont oluşturdum sonra customerController.
// postman'da get yaptım infinite hata aldım.
// GetCustomer'ı account'a bağlıyorum ama Account'u customer'a bağlamıyorum.
// bu yüzden customerResponse yazıyorum.
