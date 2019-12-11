package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChargingDataViewModel {
    @JsonProperty("cserviceId")
    private String cservice_id;
    @JsonProperty("customerId")
    private String customer_id;
    @JsonProperty("walletId")
    private String wallet_id;

    public ChargingDataViewModel() {}

    public ChargingDataViewModel(String cservice_id, String customer_id, String wallet_id) {
        this.cservice_id = cservice_id;
        this.customer_id = customer_id;
        this.wallet_id = wallet_id;
    }

    public String getCservice_id() { return cservice_id; }

    public void setCservice_id(String cservice_id) { this.cservice_id = cservice_id; }

    public String getCustomer_id() { return customer_id; }

    public void setCustomer_id(String customer_id) { this.customer_id = customer_id; }

    public String getWallet_id() { return wallet_id; }

    public void setWallet_id(String wallet_id) { this.wallet_id = wallet_id; }

}
