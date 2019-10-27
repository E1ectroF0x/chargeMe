package com.netcracker.edu.fapi.models;

public class Wallet {

    private Long id;
    private Double amount;
    private Customer customer;

    public Wallet() {}

    public Wallet(Long id, Double amount, Customer customer) {
        this.id = id;
        this.amount = amount;
        this.customer = customer;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Double getAmount() { return amount; }

    public void setAmount(Double amount) { this.amount = amount; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

}
