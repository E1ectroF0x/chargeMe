package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.RegistrationViewModel;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public String saveUser(@RequestBody RegistrationViewModel model) {
        if (!userService.save(model)) {
            return "OK";
        }
        else {
            return "UsernameAlreadyExistsException";
        }
    }

    @GetMapping("/current")
    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return userService.getUserByLogin(((org.springframework.security.core.userdetails.User) authentication.getPrincipal()).getUsername());
    }

}
