package com.netcracker.edu.backend.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChargingDataViewModel {

    @JsonProperty("cserviceId")
    private Long cservice_id;
    @JsonProperty("customerId")
    private Long customer_id;
    @JsonProperty("walletId")
    private Long  wallet_id;

    public ChargingDataViewModel(Long cservice_id, Long customer_id, Long wallet_id) {
        this.cservice_id = cservice_id;
        this.customer_id = customer_id;
        this.wallet_id = wallet_id;
    }

    public Long getCservice_id() { return cservice_id; }

    public void setCservice_id(Long cservice_id) { this.cservice_id = cservice_id; }

    public Long getCustomer_id() { return customer_id; }

    public void setCustomer_id(Long customer_id) { this.customer_id = customer_id; }

    public Long getWallet_id() { return wallet_id; }

    public void setWallet_id(Long wallet_id) { this.wallet_id = wallet_id; }

}
