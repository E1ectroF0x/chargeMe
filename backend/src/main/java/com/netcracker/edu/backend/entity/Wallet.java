package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "wallets", schema = "chargemedb", catalog = "")
public class Wallet {

    private long id;
    private Double amount;
    private Customer customer_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    public Customer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Customer customer_id) { this.customer_id = customer_id; }
}
