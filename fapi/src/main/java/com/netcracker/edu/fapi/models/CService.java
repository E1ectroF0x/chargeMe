package com.netcracker.edu.fapi.models;

public class CService {

    private Long id;
    private String name;
    private Double cost;
    private String genre;

    public CService() {}

    public CService(Long id, String name, Double cost, String genre) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.genre = genre;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getCost() { return cost; }

    public void setCost(Double cost) { this.cost = cost; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }
}
