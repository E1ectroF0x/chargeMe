package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.User;
import com.netcracker.edu.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public User save(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
