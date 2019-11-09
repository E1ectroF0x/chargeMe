package com.netcracker.edu.backend.models;

public class UserViewModel {

    private String id;
    private String username;
    private String email;
    private String totalMoney;

    public UserViewModel() {}

    public UserViewModel(String id, String username, String email, String totalMoney) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.totalMoney = totalMoney;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTotalMoney() { return totalMoney; }

    public void setTotalMoney(String totalMoney) { this.totalMoney = totalMoney; }
}
