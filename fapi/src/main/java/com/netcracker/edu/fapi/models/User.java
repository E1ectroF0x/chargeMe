package com.netcracker.edu.fapi.models;

public class User {

    private Long id;
    private String role;
    private String login;
    private String password;
    private Customer customer;

    public User() {}

    public User(Long id, String role, String login, String password, Customer customer) {
        this.id = id;
        this.role = role;
        this.login = login;
        this.password = password;
        this.customer = customer;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

}
