package com.github.vedeshkin.webapp.model;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;
    @Column(name = "cost")
    private Long cost;

    public Product(Long id, String title, Long cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Product() {
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public Long getCost() {
        return cost;
    }

    public String getCostAsString() {
        Long integerPartOfCost = cost / 100;
        Long fractionalPartOfCost = cost % 100;
        return String.format("%d,%d", integerPartOfCost, fractionalPartOfCost);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                '}';
    }
}
