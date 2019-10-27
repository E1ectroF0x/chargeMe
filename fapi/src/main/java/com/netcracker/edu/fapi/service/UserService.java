package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.User;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);
    List<User> getAll();
    User save(User user);

}
