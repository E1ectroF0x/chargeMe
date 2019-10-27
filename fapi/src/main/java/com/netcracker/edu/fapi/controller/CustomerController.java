package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.Customer;
import com.netcracker.edu.fapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = "/all")
    public List<Customer> getAll() {
        return customerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Customer getById(@PathVariable Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

}
