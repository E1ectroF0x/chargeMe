package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.Customer;
import com.netcracker.edu.fapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public Customer findById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(backendServerUrl + "/api/customers/id/" + id, Customer.class);
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Customer[] customersResponse = restTemplate.getForObject(backendServerUrl + "/api/customers/all", Customer[].class);
        return customersResponse == null ? Collections.emptyList() : Arrays.asList(customersResponse);
    }

    @Override
    public Customer save(Customer customer) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/customers", customer, Customer.class).getBody();
    }

    @Override
    public void delete(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/customers/del/" + id);
    }
}
