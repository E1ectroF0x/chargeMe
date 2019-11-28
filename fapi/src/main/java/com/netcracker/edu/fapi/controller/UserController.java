package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.RegistrationViewModel;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('USER')")
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


}
