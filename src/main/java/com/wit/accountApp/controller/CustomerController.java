package com.wit.accountApp.controller;

import com.wit.accountApp.entity.Customer;
import com.wit.accountApp.service.CustomerService;
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
    public List<Customer> findAll() {
        return  customerService.findAll();
    }

    @GetMapping("/{id}")
    public Customer find(@PathVariable long id) {
        return  customerService.find(id);
    }

    @PostMapping("/")
    public Customer save(@RequestBody Customer customer){
        return customerService.save(customer);
    }

    @PutMapping("/{id}")
    public Customer save(@RequestBody Customer customer, @PathVariable long id ){
        Customer foundCustomer = customerService.find(id);
        if (foundCustomer != null) {
            customer.setId(id);
            return customerService.save(customer);
        }
        // TODO throw exception
        return null;
    }

    @DeleteMapping("/{id}")
    public Customer delete(@PathVariable long id){
        return customerService.delete(id);
    }
}

// ilk önce addressCont oluşturdum sonra customerController.
// postman'da get yaptım infinite hata aldım.
// GetCustomer'ı account'a bağlıyorum ama Account'u customer'a bağlamıyorum.
// bu yüzden customerResponse yazıyorum.
