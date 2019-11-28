package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.RegistrationViewModel;
import com.netcracker.edu.fapi.models.User;
import com.netcracker.edu.fapi.models.UserViewModel;
import com.netcracker.edu.fapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service("customUserDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUserByLogin(String login) {
        RestTemplate restTemplate = new RestTemplate();
        User user = restTemplate.getForObject(backendServerUrl + "/api/users/" + login, User.class);
        return user;
    }

    @Override
    public List<UserViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        UserViewModel[] userResponse = restTemplate.getForObject(backendServerUrl + "/api/users/all", UserViewModel[].class);
        return userResponse == null ? Collections.emptyList() : Arrays.asList(userResponse);
    }

    @Override
    public boolean save(RegistrationViewModel model) {
        if (this.getUserByLogin(model.getLogin()) != null) {
            return false;
        }
        model.setPassword(bCryptPasswordEncoder.encode(model.getPassword()));
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "/api/users", model, User.class);
        return true;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
        return authorities;
    }
}
