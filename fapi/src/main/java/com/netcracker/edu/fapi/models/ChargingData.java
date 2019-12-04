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
    @JsonProperty("blocked")
    private boolean isBlocked;

    public ChargingData() {}

    public ChargingData(Long id, Date startDate, Customer customer, CService cService, Wallet wallet, boolean isBlocked) {
        this.id = id;
        this.startDate = startDate;
        this.customer = customer;
        this.cService = cService;
        this.wallet = wallet;
        this.isBlocked = isBlocked;
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

    public boolean isBlocked() { return isBlocked; }

    public void setBlocked(boolean blocked) { isBlocked = blocked; }
}
