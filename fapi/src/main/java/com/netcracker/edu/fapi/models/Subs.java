package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Subs {

    @JsonProperty("subscribers")
    private String subscribers;

    public Subs() {}

    public Subs(Long subscribers) {
        this.subscribers = subscribers.toString();
    }

    public String getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(String subscribers) {
        this.subscribers = subscribers;
    }
}
