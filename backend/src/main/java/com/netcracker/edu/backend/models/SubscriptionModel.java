package com.netcracker.edu.backend.models;

import com.netcracker.edu.backend.entity.CService;

public class SubscriptionModel {

    private Long id;
    private CService cservice;
    private boolean isBlocked = false;

    public SubscriptionModel () {}

    public SubscriptionModel(Long id, CService cservice, boolean isBlocked) {
        this.id = id;
        this.cservice = cservice;
        this.isBlocked = isBlocked;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public CService getCservice() { return cservice; }

    public void setCservice(CService cservice) { this.cservice = cservice; }

    public boolean isBlocked() { return isBlocked; }

    public void setBlocked(boolean blocked) { isBlocked = blocked; }
}
