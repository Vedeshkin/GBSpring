package com.github.vedeshkin.webapp.dto;

import java.util.UUID;

public class Product {
    private final String id;
    private final String title;
    private final double cost;

    public Product(String title, double cost) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.cost = cost;
    }

    public String getId() {
        return this.id;
    }
    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
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
