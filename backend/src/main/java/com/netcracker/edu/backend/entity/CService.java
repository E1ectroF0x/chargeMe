package com.netcracker.edu.backend.entity;

import javax.persistence.*;

@Entity
@Table(name = "services", schema = "chargemedb", catalog = "")
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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {return name; }

    public void setName(String name) {this.name = name; }

    @Basic
    @Column(name = "cost")
    public Double getCost() {return cost; }

    public void setCost(Double cost) {this.cost = cost; }

    @Basic
    @Column(name = "genre")
    public String getGenre() {return genre; }

    public void setGenre(String genre) {this.genre = genre; }
}
