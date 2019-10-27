package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.repository.CustomerRepository;
import com.netcracker.edu.backend.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

}
