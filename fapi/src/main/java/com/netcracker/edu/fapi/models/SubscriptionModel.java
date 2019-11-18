package com.netcracker.edu.fapi.models;

public class SubscriptionModel {
    private String id;
    private CService cservice;

    public SubscriptionModel() {}

    public SubscriptionModel(String id, CService cservice) {
        this.id = id;
        this.cservice = cservice;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public CService getCservice() { return cservice; }

    public void setCservice(CService cservice) { this.cservice = cservice; }

}
