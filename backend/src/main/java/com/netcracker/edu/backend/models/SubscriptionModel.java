package com.netcracker.edu.backend.models;

import com.netcracker.edu.backend.entity.CService;

public class SubscriptionModel {

    private Long id;
    private CService cservice;

    public SubscriptionModel () {}

    public SubscriptionModel(Long id, CService cservice) {
        this.id = id;
        this.cservice = cservice;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public CService getCservice() { return cservice; }

    public void setCservice(CService cservice) { this.cservice = cservice; }

}
