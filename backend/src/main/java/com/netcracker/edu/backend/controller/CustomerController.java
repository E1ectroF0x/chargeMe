package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Customer> getAll() {
        return customerService.getAllCustomers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer save(@RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

}
