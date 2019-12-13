package com.netcracker.edu.fapi.models;

public class UserViewModel {

    private String id;
    private String login;
    private String email;
    private String totalMoney;
    private String ROLE;

    public UserViewModel() {}

    public UserViewModel(String id, String login, String email, String totalMoney, String ROLE) {
        this.id = id;
        this.login = login;
        this. email = email;
        this.totalMoney = totalMoney;
        this.ROLE = ROLE;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getLogin() { return login; }

    public void setLogin(String login) { this.login = login; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getTotalMoney() { return totalMoney; }

    public void setTotalMoney(String totalMoney) { this.totalMoney = totalMoney; }

    public String getROLE() { return ROLE; }

    public void setROLE(String ROLE) { this.ROLE = ROLE; }
}

