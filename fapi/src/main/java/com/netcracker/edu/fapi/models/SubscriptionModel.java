package com.netcracker.edu.fapi.models;

public class SubscriptionModel {
    private String id;
    private CService cservice;
    private boolean isBlocked;

    public SubscriptionModel() {}

    public SubscriptionModel(String id, CService cservice, boolean isBlocked) {
        this.id = id;
        this.cservice = cservice;
        this.isBlocked = isBlocked;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public CService getCservice() { return cservice; }

    public void setCservice(CService cservice) { this.cservice = cservice; }

    public boolean isBlocked() { return isBlocked; }

    public void setBlocked(boolean blocked) { isBlocked = blocked; }

}
