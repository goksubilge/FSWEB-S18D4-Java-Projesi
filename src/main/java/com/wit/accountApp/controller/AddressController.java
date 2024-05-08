package com.wit.accountApp.controller;

import com.wit.accountApp.entity.Address;
import com.wit.accountApp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    // address üstünde bir foreign key yok, istenilen her işlem rahatça yapılabilir.
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/")
    public List<Address> findAll() {
        return  addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address find(@PathVariable long id) {
        return  addressService.find(id);
    }

    @PostMapping("/")
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address save(@RequestBody Address address, @PathVariable long id ){
        Address foundAddress = addressService.find(id);
        if (foundAddress != null) {
            address.setId(id);
            return addressService.save(address);
        }
        // TODO throw exception
        return null;
    }

    @DeleteMapping("/{id}")
    public Address delete(@PathVariable long id){
        return addressService.delete(id);
    }
}
