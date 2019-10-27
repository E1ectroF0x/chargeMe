package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User saveUser(User user);
    void deleteUser(Long id);
    User saveCustomer(User user, Customer customer);
}
