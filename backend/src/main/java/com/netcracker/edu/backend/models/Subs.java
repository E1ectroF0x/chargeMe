package com.netcracker.edu.backend.models;

public class Subs {
    private String subscribers;

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
