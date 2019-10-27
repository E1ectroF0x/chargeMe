package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.Customer;

import java.util.List;

public interface CustomerService {

    Customer findById(Long id);
    List<Customer> findAll();
    Customer save(Customer customer);
    void delete(Long id);

}
