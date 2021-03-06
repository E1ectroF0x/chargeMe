package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "customers", schema = "chargemedb", catalog = "")
public class Customer {
    private long id;
    private String email;

    public Customer() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
