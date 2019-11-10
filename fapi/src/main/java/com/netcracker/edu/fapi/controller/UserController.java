package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.RegistrationViewModel;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    @GetMapping(value = "/all")
    public List<User> getAll() {
        return userService.getAll();
    }
    */

    @GetMapping(value = "/all")
    public List<UserViewModel> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/{login}")
    public User getByLogin(@PathVariable String login) {
        return userService.getUserByLogin(login);
    }

    @PostMapping
    public void saveUser(@RequestBody RegistrationViewModel model) {
        userService.save(model);
    }

    /*
    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }
    */

}
