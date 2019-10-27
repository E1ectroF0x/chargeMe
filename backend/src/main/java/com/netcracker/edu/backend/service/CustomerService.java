package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer saveCustomer(Customer customer);
    void deleteCustomer(Long id);
}
