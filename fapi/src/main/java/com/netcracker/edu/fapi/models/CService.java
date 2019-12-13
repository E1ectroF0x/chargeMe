package com.netcracker.edu.fapi.models;

public class CService {

    private Long id;
    private String name;
    private Double cost;
    private String genre;
    private String image;
    private String description;

    public CService() {}

    public CService(Long id, String name, Double cost, String genre, String image, String description) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.genre = genre;
        this.image = image;
        this.description = description;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Double getCost() { return cost; }

    public void setCost(Double cost) { this.cost = cost; }

    public String getGenre() { return genre; }

    public void setGenre(String genre) { this.genre = genre; }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
