package com.course.day17;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private int priceCents;
    protected Product() {}
    public Product(String name, String category, int priceCents) {
        this.name = name; this.category = category; this.priceCents = priceCents;
    }
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public int getPriceCents() { return priceCents; }
}
