package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.RegistrationViewModel;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;

import java.util.List;

public interface UserService {

    User getUserByLogin(String login);
    List<UserViewModel> getAll();
    //List<User> getAll();
    //User save(User user);
    void save(RegistrationViewModel model);

}
