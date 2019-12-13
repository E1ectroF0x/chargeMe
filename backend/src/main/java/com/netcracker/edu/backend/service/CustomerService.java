package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getById(Long customer_id);
    Customer saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
