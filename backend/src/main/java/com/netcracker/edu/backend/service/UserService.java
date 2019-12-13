package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Customer;
import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.models.RegistrationViewModel;
import com.netcracker.edu.backend.models.UserViewModel;

import java.util.List;

public interface UserService {
    List<UserViewModel> getAll();
    User getByLogin(String login);
    //List<User> getAllUsers();
    User saveUser(RegistrationViewModel model);
    //User saveUser(User user);
    void deleteUser(Long id);
    User saveCustomer(User user, Customer customer);
}
