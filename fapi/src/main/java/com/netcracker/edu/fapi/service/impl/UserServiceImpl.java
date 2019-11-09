package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public User getUserByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendServerUrl + "/api/users/login/" + login, User.class);
        return user;
    }

    @Override
    public List<UserViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userResponse = restTemplate.getForObject(backendServerUrl + "/api/users/all", UserViewModel[].class);
        return userResponse == null ? Collections.emptyList() : Arrays.asList(userResponse);
    }

    /*
    @Override
    public List<User> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        User[] userResponse = restTemplate.getForObject(backendServerUrl + "/api/users/all", User[].class);
        return userResponse == null ? Collections.emptyList() : Arrays.asList(userResponse);
    }
    */

    @Override
    public User save(User user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/users", user, User.class).getBody();
    }
}
