package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "users", schema = "chargemedb", catalog = "")
public class User {

    private Long id;

    private String role;
    private String login;
    private String password;

    private Customer customer;

    public User() {}

    public User(String role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }

    @Id
    @Column(name = "id")
    public Long getId() {return id; }

    public void setId(Long id) {this.id = id; }

    @Basic
    @Column(name = "role")
    public String getRole() {return role; }

    public void setRole(String role) {this.role = role; }

    @Basic
    @Column(name = "login")
    public String getLogin() {return login; }

    public void setLogin(String login) {this.login = login; }

    @Basic
    @Column(name = "password")
    public String getPassword() {return password; }

    public void setPassword(String password) {this.password = password; }

    @OneToOne
    @JoinColumn(name = "customer", referencedColumnName = "id")
    public Customer getCustomer() {return customer; }

    public void setCustomer(Customer customer) {this.customer = customer; }
}

