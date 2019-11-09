package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ChargingData {

    private Long id;
    private Date startDate;
    @JsonProperty("customerId")
    private Customer customer;
    @JsonProperty("serviceId")
    private CService cService;
    @JsonProperty("walletId")
    private Wallet wallet;

    public ChargingData() {}

    public ChargingData(Long id, Date startDate, Customer customer, CService cService, Wallet wallet) {
        this.id = id;
        this.startDate = startDate;
        this.customer = customer;
        this.cService = cService;
        this.wallet = wallet;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

    public Customer getCustomer() { return customer; }

    public void setCustomer(Customer customer) { this.customer = customer; }

    public CService getcService() { return cService; }

    public void setcService(CService cService) { this.cService = cService; }

    public Wallet getWallet() { return wallet; }

    public void setWallet(Wallet wallet) { this.wallet = wallet; }

}
